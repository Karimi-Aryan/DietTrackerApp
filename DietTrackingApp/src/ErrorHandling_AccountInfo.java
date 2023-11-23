
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class ErrorHandling_AccountInfo implements ErrorInterface {

    private User user;
    private String year;
    private String month;
    private String day;
    
   public ErrorHandling_AccountInfo(User localUser){
    
    this.user = localUser;
    
}
   
   public ErrorHandling_AccountInfo(){
    
    
}
   
   public int ErrorCheck_AccountInfo(){
       
     
      if (this.user.getFirstName().length() >45 || this.user.getLastName().length() > 45){
            
            //show: too many characters for first or last name
            
            JOptionPane.showMessageDialog(null, "First or Last Name must be less than 45 characters"
                    , "Invalid First or Last Name : ", JOptionPane.ERROR_MESSAGE);
            
            return 1;
        }
        
        if (this.user.getFirstName().equals("") || this.user.getLastName().equals("")){
            
            //show: too many characters for first or last name
            
            
            JOptionPane.showMessageDialog(null, "First or Last Name cannot be empty"
                    , "Invalid First or Last Name : ", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        
       
        if (Double.toString(this.user.getWeight()).length() >45 || Double.toString(this.user.getHeight()).length() > 45){
            
            //show: number is too high for height or weight 
            
            
             JOptionPane.showMessageDialog(null, "Weight or Height is Invalid"
                    , "Invalid weight or height: ", JOptionPane.ERROR_MESSAGE);
            return 1;
            
        }
        
        if (Double.toString(this.user.getWeight()).length() <0 || Double.toString(this.user.getHeight()).length() <0){
            
            //show: cant have empty number 
            
            JOptionPane.showMessageDialog(null, "Cannot have empty number"
                    , "Invalid weight or height: ", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        
        if (this.user.getWeight() <0 || this.user.getHeight() <0){
            
            //show: cant have negative number 
            
            JOptionPane.showMessageDialog(null, "Cannot have negative number"
                    , "Invalid weight or height: ", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        
  
        
        
        try {
            LocalDate userDob = LocalDate.parse(this.user.getDob());
            
            LocalDate currentDate = LocalDate.now();
        
        Period period = Period.between(userDob,currentDate);
        
        if(period.getYears() > 150){
            
            JOptionPane.showMessageDialog(null, "Please put valid date"
                    , "Invalid Date: ", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        }
        catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "Please put valid date"
                    , "Invalid Date: ", JOptionPane.ERROR_MESSAGE);
            
            
        }
        
       return 0;
       
   }
   
    @Override
   public int ErrorCheck_Date(String dob){
       
       try {
            LocalDate userDob = LocalDate.parse(dob);
            
        }
        catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "Please put valid date"
                    , "Invalid Date: ", JOptionPane.ERROR_MESSAGE);
            return 1;
            
            
        }
       return 0;
   }
   
    @Override
   public String [] DateCleanUp(String year, String month, String day){
       
       String [] monthAndDay = {year,month,day};
       
       if(Integer.parseInt(month)<10 && !"0".equals(month.substring(0,1)) ){
            
            //add 0 to month number to avoid any date errors
            
            month = "0" + month;
            monthAndDay[1] = month;
            
        }
        
        if(Integer.parseInt(day)<10 && !"0".equals(day.substring(0,1)) ){
            
            //add 0 to day number to avoid any date errors 
            day = "0" + day;
            monthAndDay[2] = day;
            
        }
        
        return monthAndDay;
   }
   
   public int EmptyCheck_Date(String year, String month, String day){
       if (year.length() <4 || month.length()<2 || day.length() <2){
           
           JOptionPane.showMessageDialog(null, "Please put a valid date"
                    , "Invalid Date of Birth: ", JOptionPane.ERROR_MESSAGE);
           return 1;
       }
       return 0;
   }
   
   public int EmptyCheck_Name(String fname, String lname){
       if (fname.equals("") || lname.equals("")){
           JOptionPane.showMessageDialog(null, "Please complete first and last name fields"
                    , "Incomplete First or Last Name: ", JOptionPane.ERROR_MESSAGE);
           
           return 1;
       }
       
   
         return 0;  
   }
   
   public int EmptyCheck_Units(String weight, String height){
       
       if (weight.equals("") || height.equals("") ){
           JOptionPane.showMessageDialog(null, "Please complete weight and height fields"
                    , "Incomplete Weight or Height: ", JOptionPane.ERROR_MESSAGE);
           return 1;
           
       }
       return 0;
   }
    
}
