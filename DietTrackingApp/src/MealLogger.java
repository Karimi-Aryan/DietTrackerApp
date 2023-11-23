import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// Class responsible for logging meals into a database
public class MealLogger {


   // Database connection and statements
   private Connection connection;
   private Statement statement;
   private Statement nutrientStatement;
   private Statement nutrientNameStatement;
   private Statement dietStatement;


   // Constructor to establish a connection to the database
   public MealLogger() {
      try {
         // Connect to the MySQL database with the specified credentials
         SQLConnection sqlConnect = new SQLConnection();
         this.connection = sqlConnect.SQLConnect();


         // Create statements for executing SQL queries
         this.statement = this.connection.createStatement();
         this.nutrientStatement = this.connection.createStatement();
         this.nutrientNameStatement = this.connection.createStatement();
         this.dietStatement = this.connection.createStatement();
      } catch (SQLException var2) {
         var2.printStackTrace();
      }
   }


   // Method to log a meal into the database
   public boolean logMeal(int accountID, String mealType, String mealName, String date) {
      try (
              Statement outerStatement = this.connection.createStatement();
              ResultSet resultSet = outerStatement.executeQuery("SELECT * FROM food_name WHERE FoodDescription = '" + mealName + "'")
      ) {
         double totalCalories = 0.0;
         while (resultSet.next()) {
            int foodID = resultSet.getInt("FoodID");
            String foodGroupName = getFoodGroupName(foodID);
            logMealInfo(accountID, mealType, date, foodID, foodGroupName);

            try (
                    // Execute a query to retrieve nutrient information for the specified food ID
                    Statement nutrientStatement = this.connection.createStatement();
                    ResultSet nutrientResultSet = nutrientStatement.executeQuery("SELECT * FROM nutrient_amount WHERE FoodID = " + foodID)
            ){
               while (nutrientResultSet.next()) {
                  int nutrientID = nutrientResultSet.getInt("NutrientID");
                  double nutrientValue = nutrientResultSet.getDouble("NutrientValue");
                  // Check if the nutrient is calories (NutrientID 208)
                  if (nutrientID == 208) {
                     totalCalories += nutrientValue;
                  }


                  try (
                          // Execute a query to retrieve the nutrient name for the specified nutrient ID
                          ResultSet nutrientNameResultSet = this.nutrientNameStatement.executeQuery("SELECT NutrientUnit, NutrientName FROM nutrient_name WHERE NutrientID = " + nutrientID)
                  ) {
                     if (nutrientNameResultSet.next()) {
                        String nutrientName = nutrientNameResultSet.getString("NutrientName");
                        String nutrientUnit = nutrientNameResultSet.getString("NutrientUnit");


                        // Prepare and execute an SQL statement to insert meal data into the user_diet table
                        String insert = "INSERT INTO user_diet (FoodID, NutrientID, NutrientValue, NutrientName, NutrientUnit, MealType, MealName, LogDate, AccountID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
                           preparedStatement.setInt(1, foodID);
                           preparedStatement.setInt(2, nutrientID);
                           preparedStatement.setDouble(3, nutrientValue);
                           preparedStatement.setString(4, nutrientName);
                           preparedStatement.setString(5,  nutrientUnit);
                           preparedStatement.setString(6, mealType);
                           preparedStatement.setString(7, mealName);
                           preparedStatement.setString(8, date);
                           preparedStatement.setInt(9, accountID);
                           preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                           e.printStackTrace();
                           return false; // Log failed
                        }
                     } else {
                        System.out.println("No matching nutrient name found for NutrientID: " + nutrientID);
                     }
                  }
               }
            }
         }


         // Update the total calories in the calories table
         updateTotalCaloriesInCaloriesTable(accountID, date, totalCalories);
         return true; // Log successful
      } catch (SQLException var11) {
         var11.printStackTrace();
         return false; // Log failed
      }
   }

   private void logMealInfo(int accountID, String mealType, String date, int foodID, String foodGroupName) {
      try (
              // Create a new statement for the meal_info insert
              PreparedStatement mealInfoStatement = connection.prepareStatement(
                      "INSERT INTO meal_info (FoodID, FoodGroupName, AccountID, MealType, LogDate) VALUES (?, ?, ?, ?, ?)"
              )
      ) {
         mealInfoStatement.setInt(1, foodID);
         mealInfoStatement.setString(2, foodGroupName);
         mealInfoStatement.setInt(3, accountID);
         mealInfoStatement.setString(4, mealType);
         mealInfoStatement.setString(5, date);
         mealInfoStatement.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("Failed to log meal info");
      }
   }



   // Private method to update total calories in the calories table
   private void updateTotalCaloriesInCaloriesTable(int accountID, String date, double totalCalories) {
      try {
         // Check if an entry already exists for the specified account and date
         if (entryExistsForAccountAndDate(accountID, date)) {
            // If entry exists, update the total calories
            String updateQuery = "UPDATE calories_intake_info SET TotalCalories = TotalCalories + ? WHERE AccountID = ? AND Date = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
               updateStatement.setDouble(1, totalCalories);
               updateStatement.setInt(2, accountID);
               updateStatement.setString(3, date);
               updateStatement.executeUpdate();
            }
         } else {
            // If entry does not exist, insert a new row with the total calories
            String insertQuery = "INSERT INTO calories_intake_info (AccountID, TotalCalories, Date) VALUES (?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
               insertStatement.setInt(1, accountID);
               insertStatement.setDouble(2, totalCalories);
               insertStatement.setString(3, date);
               insertStatement.executeUpdate();
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }


   // Method to check if an entry already exists for a specific account and date in the calories table
   private boolean entryExistsForAccountAndDate(int accountID, String date) {
      try (
              // Execute a query to check for the existence of an entry for the specified account and date
              ResultSet resultSet = this.dietStatement.executeQuery("SELECT * FROM calories_intake_info WHERE AccountID = " + accountID + " AND Date = '" + date + "'")
      ) {
         return resultSet.next(); // If resultSet has a next row, entry exists
      } catch (SQLException e) {
         e.printStackTrace();
         return true; // Default to true if an exception occurs
      }
   }


   // Private method to check if an entry already exists for a specific meal type and date
   public boolean entryExistsForMealType(String mealType, String date) {
      try (
              // Execute a query to check for the existence of an entry for the specified meal type and date
              ResultSet resultSet = this.dietStatement.executeQuery("SELECT * FROM user_diet WHERE MealType = '" + mealType + "' AND LogDate = '" + date + "'")
      ) {
         return resultSet.next(); // If resultSet has a next row, entry exists
      } catch (SQLException e) {
         e.printStackTrace();
         return true; // Default to true if an exception occurs
      }
   }


   private String getFoodGroupName(int foodID) throws SQLException {
      try (
              ResultSet foodGroupResultSet = this.statement.executeQuery(
                      "SELECT food_group.FoodGroupName FROM food_group JOIN food_name ON food_group.FoodGroupID = food_name.FoodGroupID WHERE food_name.FoodID = " + foodID
              )
      ) {
         if (foodGroupResultSet.next()) {
            return foodGroupResultSet.getString("FoodGroupName");
         } else {
            // Handle the case where no matching food group is found
            System.out.println("No matching food group found for FoodID: " + foodID);
            return null;
         }
      }
   }


   // Method to close database connections
   public void closeConnections() {
      try {
         this.statement.close();
         this.nutrientStatement.close();
         this.nutrientNameStatement.close();
         this.dietStatement.close();
         this.connection.close();
      } catch (SQLException var2) {
         var2.printStackTrace();
      }
   }
}

