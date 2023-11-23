import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CalorieCalculator {

    private final double intensityLevel_Easy = 1.375;
    private final double intensityLevel_Medium = 1.55;
    private final double intensityLevel_Hard = 1.725;
    private final double intensityLevel_VeryHard = 1.9;

    public double calculateCaloriesBurned(ExerciseUser exercUser) {

        try {
            BMRCalculator b = new BMRCalculator();
//		System.out.println("\nIn calculateCaloriesBurned Method: "+exercUser.getHeight()+exercUser.getWeight()+exercUser.getAge()+exercUser.getSex()+exercUser.getUnits());
            int BMR = b.BMRCalc(exercUser.getHeight(), exercUser.getWeight(), exercUser.getAge(), exercUser.getSex(), exercUser.getUnits());

            double duration = exercUser.getDuration();
            double weight = exercUser.getWeight();
            String intensity = exercUser.getIntensity();
            double intensityMultiplier;

            if(intensity.equals("Easy")) {
                intensityMultiplier = intensityLevel_Easy;
            }
            else if(intensity.equals("Medium")) {
                intensityMultiplier = intensityLevel_Medium;
            }
            else if(intensity.equals("Hard")) {
                intensityMultiplier = intensityLevel_Hard;
            }
            else{
                intensityMultiplier = intensityLevel_VeryHard;
            }

            SQLConnection sqlConnect = new SQLConnection();
            Connection connect = sqlConnect.SQLConnect();
            String sql = "SELECT * FROM exercise_data where Activity = '"+exercUser.getExercise()+"'";
            System.out.println("exercUser.getExercise(): "+exercUser.getExercise());

            Statement stm = connect.createStatement();
            ResultSet result = stm.executeQuery(sql);

            double MET = 1;

            while(result.next()) {
                MET = result.getDouble("MET");
            }

            double totalCaloriesBurned = (BMR * intensityMultiplier) + (MET * weight * duration)/200;

            return totalCaloriesBurned;
        }
        catch(Exception e) {
            System.out.println("Something went wrong..");
            e.printStackTrace();
            return 1;
        }
    }
}

