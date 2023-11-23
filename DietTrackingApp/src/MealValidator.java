import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Class responsible for validating meal-related data
public class MealValidator {

    // Database connection and statement
    private Connection connection;
    private Statement statement;

    // Constructor to establish a connection to the database
    public MealValidator() {
        try {
            // Connect to the MySQL database with the specified credentials
            // Note: It's a good practice to use a try-with-resources statement for AutoCloseable resources like Connection
            //this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DietTracker", "root", "Tenzin110");
            SQLConnection sqlConnect = new SQLConnection();
            this.connection = sqlConnect.SQLConnect();

            // Create a statement for executing SQL queries
            this.statement = this.connection.createStatement();
        } catch (SQLException var2) {
            var2.printStackTrace(); // Print the exception stack trace for debugging
        }
    }

    // Method to check if a meal type is valid
    public static boolean isValidMealType(String mealType) {
        return mealType != null && !mealType.trim().isEmpty();
    }

    // Method to check if a meal name is valid
    public boolean isValidMealName(String mealName) {
        // Empty meal name is not valid
        if (mealName == null || mealName.trim().isEmpty()) {
            return false;
        }

        try {
            // Execute a query to check if the meal name exists in the database
            ResultSet resultSet = this.statement.executeQuery("SELECT * FROM food_name WHERE FoodDescription = '" + mealName + "'");
            return resultSet.next(); // If resultSet has a next row, the mealName exists
        } catch (SQLException var4) {
            var4.printStackTrace();
            return false; // Default to false if an exception occurs
        }
    }

    // Method to check if a date is valid
    public static boolean isValidDate(String date) {
        // Use a SimpleDateFormat to parse and validate the date format (yyyy-MM-dd)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            Date parsedDate = dateFormat.parse(date);
            return true; // If parsing is successful, the date is valid
        } catch (ParseException e) {
            return false; // If an exception occurs during parsing, the date is not valid
        }
    }

    // Method to close database connections
    public void closeConnections() {
        try {
            this.statement.close();
            this.connection.close();
        } catch (SQLException var2) {
            var2.printStackTrace();
        }
    }
}
