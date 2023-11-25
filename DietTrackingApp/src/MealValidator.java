import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Class responsible for validating meal-related data
public class MealValidator {

    // Database connection and statement
    private Connection connection;
    private Statement statement;

    // Constructor to establish a connection to the database
    public MealValidator() {
        try {
            SQLConnection sqlConnect = new SQLConnection();
            this.connection = sqlConnect.SQLConnect();

            // Create a statement for executing SQL queries
            this.statement = this.connection.createStatement();
        } catch (SQLException var2) {
            var2.printStackTrace(); // Print the exception stack trace for debugging
        }
    }

    // Method to check if a meal type is valid
    public boolean isValidMealType(String mealType) {
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
    public boolean isValidDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate parsedDate = LocalDate.parse(date, dateFormatter);
            return true; // If parsing is successful, the date is valid
        } catch (Exception e) {
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

