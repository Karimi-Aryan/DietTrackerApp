import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

public class ExerciseUser extends User {
	private Date date;
	private String intensity;
	private String exercise;
	private double duration;
	private int totalCaloriesBurned;
	private int account_id;
	
	public ExerciseUser(User user, Date date, Double duration, String exercise, String intensity) {
		super(user.accID, user.firstName, user.lastName, user.age, user.weight, user.height, user.sex, user.units);
		account_id = user.getAccID();
		this.exercise = exercise;
		this.intensity = intensity;
		this.duration = duration;
		this.date = date;
	}
	public String getIntensity() {
		return intensity;
	}
	public Double getDuration() {
		return duration;
	}
	public String getExercise() {
		return exercise;
	}
	public Date getDate() {
		return date;
	}

	public void insertExerciseData() throws SQLException {
        SQLConnection sqlConnect = new SQLConnection();
        Connection connect = sqlConnect.SQLConnect();

        CalorieCalculator newCalc = new CalorieCalculator();
        totalCaloriesBurned = (int)newCalc.calculateCaloriesBurned(this);
        
		String sqlQuery = "SELECT * FROM exercise_log WHERE exercise_date = ?";
		PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		preparedStatement.setDate(1, sqlDate);
		
		ResultSet resultSet = preparedStatement.executeQuery();

		if(resultSet.next()) {
			   ResultSetMetaData rsmd = resultSet.getMetaData();
			   System.out.println("\nquerying SELECT * FROM XXX");
			   int columnsNumber = rsmd.getColumnCount();
			   while (resultSet.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = resultSet.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			       System.out.println("");
			   }
			   
			String sumQuery = "SELECT SUM(calories_burned) AS total_calories FROM exercise_log WHERE exercise_date = ?";
			String updateStatement = "UPDATE exercise_log SET calories_burned = ? WHERE exercise_date = ?";
			// Create a Statement and a PreparedStatement
			PreparedStatement sumPreparedStatement = connect.prepareStatement(sumQuery);
			PreparedStatement updatePreparedStatement = connect.prepareStatement(updateStatement);
			
			sumPreparedStatement.setDate(1, sqlDate);
			ResultSet resultSet2 = sumPreparedStatement.executeQuery();
			
			int totalCalories = totalCaloriesBurned;
			if(resultSet2.next()) {
			    totalCalories += resultSet2.getInt("total_calories");
			}
			
			// Step 2: Update the row with the calculated sum
			updatePreparedStatement.setInt(1, totalCalories);
			updatePreparedStatement.setDate(2, sqlDate);
			updatePreparedStatement.executeUpdate();
		}
		else {
			String sql = "INSERT INTO exercise_log(AccountID,exercise_date,exercise_intensity,exercise_type,exercise_duration,calories_burned) VALUES (?,?,?,?,?,?)";
			preparedStatement = connect.prepareStatement(sql);

			preparedStatement = connect.prepareStatement(sql);
	        preparedStatement.setInt(1, account_id);
	        preparedStatement.setDate(2, sqlDate);
	        preparedStatement.setString(3, intensity);
	        preparedStatement.setString(4, exercise);
	        preparedStatement.setDouble(5, duration);
	        preparedStatement.setInt(6, totalCaloriesBurned);
	        
			preparedStatement.executeUpdate();
		}            
	}
	
}
