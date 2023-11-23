
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class FatLossCalculator implements CalculatorInterface {
    
    int numEntries;
    int totalCals_BiWeekly;
    int avg_Coloric_Intake;
    int avg_Cals_Burned;
    int bmr;
    int calsDeficit;
    
    
    FatLossCalculator() {
        
        this.bmr = 0;
        
}
    
     public int getCalsLost(int calsBurned, int calIntake){
         
      
         int calsEndofDay = calIntake - calsBurned;
         
         
         return calsEndofDay - this.bmr;
        
    }
     
     public void getBmr(double height, double weight, int age, String sex, String units){
         
        BMRCalculator userBmr  = new BMRCalculator();
        this.bmr = userBmr.BMRCalc(height, weight, age, sex, units);
     }
    
    public int getDailyColoric_Avg(int accID){
        
        
        try{
        
        SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
          
          //get the Calories consumed over the last 14 days and number of entries 
          
          String sqlQuery = "SELECT count(AccountID), sum(TotalCalories) FROM AccountInfo.new_table "
                  + "where AccountID = "+accID+" and Date between date_add(curdate(), interval -14 day) and curdate() and Date != curdate() "
                  + "ORDER BY DATE DESC "
                  + "LIMIT 14;";
          
          Statement stmt = connect.createStatement();
           ResultSet rs = stmt.executeQuery(sqlQuery);
           
           
           
           rs.next();
           
           numEntries = rs.getInt(1);
           totalCals_BiWeekly =rs.getInt(2);
           
           avg_Coloric_Intake = totalCals_BiWeekly / numEntries;
           
           
           
           return avg_Coloric_Intake;
                   
                   
        }
        catch (Exception e){
            
        }
        
        
        return avg_Coloric_Intake;
    }
    
    public int getBiWeeklyCalsBurned_Avg(int accID){
      
        
        try{
        
        SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
          
          //get the Calories consumed over the last 14 days and number of entries 
          
          String sqlQuery = "SELECT count(AccountID), sum(CaloriesBurned) FROM AccountInfo.ExerciseT where AccountID = "+accID+" and Date between date_add(curdate(), interval -14 day) and curdate() and Date != curdate() ORDER BY DATE DESC LIMIT 14;";
          
          Statement stmt = connect.createStatement();
           ResultSet rs = stmt.executeQuery(sqlQuery);
           
          
           
           rs.next();
           
           numEntries = rs.getInt(1);
           
           
           
           totalCals_BiWeekly =rs.getInt(2);
           
           System.out.println();
           
           avg_Cals_Burned = totalCals_BiWeekly / numEntries;
            
           System.out.println();
           
           return avg_Cals_Burned;
                   
                   
        }
        catch (Exception e){
            
        }
        
        
        return avg_Cals_Burned;
    }

    @Override
    public int BMRCalc(double height, double weight, int age, String sex, String units) {
        BMRCalculator userBmr  = new BMRCalculator();
        this.bmr = userBmr.BMRCalc(height, weight, age, sex, units);
    }

    
}
