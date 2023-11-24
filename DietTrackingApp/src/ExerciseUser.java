import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

public class ExerciseUser extends User{
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

		String sql = "INSERT INTO exercise_log(AccountID,exercise_date,exercise_intensity,exercise_type,exercise_duration,calories_burned) VALUES (?,?,?,?,?,?)";

		PreparedStatement preparedStatement = connect.prepareStatement(sql);

		preparedStatement = connect.prepareStatement(sql);
		preparedStatement.setInt(1, account_id);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		preparedStatement.setDate(2, sqlDate);
		preparedStatement.setString(3, intensity);
		preparedStatement.setString(4, exercise);
		preparedStatement.setDouble(5, duration);
		preparedStatement.setInt(6, totalCaloriesBurned);

		preparedStatement.executeUpdate();

		insertCalorieTotal(totalCaloriesBurned, date);

	}
	public void insertCalorieTotal(int totalCaloriesforDate, Date date) throws SQLException{
		SQLConnection sqlConnect = new SQLConnection();
		Connection connect = sqlConnect.SQLConnect();

		String sqlQuery = "SELECT * FROM calories_total WHERE Date = ?";
		PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		preparedStatement.setDate(1, sqlDate);

		ResultSet resultSet = preparedStatement.executeQuery();

		if(resultSet.next()) {
			totalCaloriesforDate += resultSet.getInt("CaloriesBurnedTotal");
			String updateStatement = "UPDATE calories_total SET CaloriesBurnedTotal = ? WHERE Date = ?";
			PreparedStatement updatePreparedStatement = connect.prepareStatement(updateStatement);		
			// Step 2: Update the row with the calculated sum
			updatePreparedStatement.setInt(1, totalCaloriesforDate);
			updatePreparedStatement.setDate(2, sqlDate);
			updatePreparedStatement.executeUpdate();
		}
		else {
			String sql = "INSERT INTO calories_total(AccountID,CaloriesBurnedTotal,Date) VALUES (?,?,?)";
			PreparedStatement insertStatement = connect.prepareStatement(sql);
			insertStatement = connect.prepareStatement(sql);

			insertStatement.setInt(1, account_id);
			insertStatement.setInt(2, totalCaloriesforDate);
			insertStatement.setDate(3, sqlDate);

			insertStatement.executeUpdate();
		}
	}
}