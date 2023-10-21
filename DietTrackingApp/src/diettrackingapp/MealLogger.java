// Source code is decompiled from a .class file using FernFlower decompiler.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MealLogger {
   private Connection connection;
   private Statement statement;
   private Statement nutrientStatement;
   private Statement nutrientNameStatement;
   private Statement dietStatement;

   public MealLogger() {
      try {
         this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Deliverable1", "root", "Tenzin110");
         this.statement = this.connection.createStatement();
         this.nutrientStatement = this.connection.createStatement();
         this.nutrientNameStatement = this.connection.createStatement();
         this.dietStatement = this.connection.createStatement();
      } catch (SQLException var2) {
         var2.printStackTrace();
      }

   }

   public void logMeal(String foodDescription) {
      try {
         ResultSet resultSet = this.statement.executeQuery("SELECT * FROM foodName WHERE FoodDescription = '" + foodDescription + "'");

         while(resultSet.next()) {
            int foodID = resultSet.getInt("FoodID");

            ResultSet nutrientResultSet;
            ResultSet nutrientNameResultSet;
            for(nutrientResultSet = this.nutrientStatement.executeQuery("SELECT * FROM  nutrientAmount WHERE FoodID = " + foodID); nutrientResultSet.next(); nutrientNameResultSet.close()) {
               int nutrientID = nutrientResultSet.getInt("NutrientID");
               double nutrientValue = nutrientResultSet.getDouble("NutrientValue");
               nutrientNameResultSet = this.nutrientNameStatement.executeQuery("SELECT NutrientName FROM  nutrientName WHERE NutrientID = " + nutrientID);
               if (nutrientNameResultSet.next()) {
                  String nutrientName = nutrientNameResultSet.getString("NutrientName");
                  String insert = "INSERT INTO dietData (FoodID, NutrientID, NutrientValue, NutrientName) VALUES (" + foodID + ", " + nutrientID + ", " + nutrientValue + ", '" + nutrientName + "' )";
                  this.dietStatement.executeUpdate(insert);
               } else {
                  System.out.println("No matching nutrient name found for NutrientID: " + nutrientID);
               }
            }

            nutrientResultSet.close();
         }

         resultSet.close();
      } catch (SQLException var11) {
         var11.printStackTrace();
      }

   }

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
