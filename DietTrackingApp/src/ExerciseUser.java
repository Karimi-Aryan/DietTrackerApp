import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ExerciseUser extends User{
    private String date;
    private String intensity;
    private String exercise;
    private double duration;
    private int exerciseID;

    public ExerciseUser(User user, String date, Double duration, String exercise, String intensity) {
        super(user.accID, user.firstName, user.lastName, user.age, user.weight, user.height, user.sex, user.units);
        exerciseID = super.accID;
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
    public String getDate() {
        return date;
    }
    public void insertExerciseData() throws SQLException {
        SQLConnection sqlConnect = new SQLConnection();
        Connection connect = sqlConnect.SQLConnect();

        String sql = "INSERT INTO exercise_log(exercise_date,exercise_intensity,exercise_type,exercise_duration,exercise_ID) VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setString(1, date);
        preparedStatement.setString(2, intensity);
        preparedStatement.setString(3, exercise);
        preparedStatement.setDouble(4, duration);
        preparedStatement.setInt(5, exerciseID);

        int rows = preparedStatement.executeUpdate();
        if(rows > 0) {
            System.out.println("Exercise data logged in");
        }
    }
    public void insertCaloriesBurned() throws SQLException{
        SQLConnection sqlConnect = new SQLConnection();
        Connection connect = sqlConnect.SQLConnect();

        CalorieCalculator newCalc = new CalorieCalculator();
        double totalCaloriesBurnt = newCalc.calculateCaloriesBurned(this);

        String sql = "UPDATE exercise_log SET calories_burned = ? WHERE exercise_ID = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setDouble(1,totalCaloriesBurnt);
        preparedStatement.setInt(2,this.exerciseID);

        int result = preparedStatement.executeUpdate();

        if (result > 0) {
            System.out.println("Updated calories burnt");
        }
        else {
            System.out.println("Unable to add calories burnt");
        }

    }
}