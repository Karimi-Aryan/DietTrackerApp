// Source code is decompiled from a .class file using FernFlower decompiler.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInterface {
   private Connection connection;
   private Statement statement;

   public UserInterface() {
      try {
         this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Deliverable1", "root", "Tenzin110");
         this.statement = this.connection.createStatement();
      } catch (SQLException var2) {
         var2.printStackTrace();
      }

   }

   public String getUserInput() {
      Scanner scanner = new Scanner(System.in);

      while(true) {
         System.out.print("Enter a food description: ");
         String userInput = scanner.nextLine();

         try {
            ResultSet resultSet = this.statement.executeQuery("SELECT * FROM foodName WHERE FoodDescription = '" + userInput + "'");
            if (resultSet.next()) {
               return userInput;
            }

            System.out.println("Food not found. Please try again.");
         } catch (SQLException var4) {
            var4.printStackTrace();
         }
      }
   }

   public void closeConnections() {
      try {
         this.statement.close();
         this.connection.close();
      } catch (SQLException var2) {
         var2.printStackTrace();
      }

   }
}
