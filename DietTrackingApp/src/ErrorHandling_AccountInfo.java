
import java.time.LocalDate;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class ErrorHandling_AccountInfo {

    private User user;
    private String year;
    private String month;
    private String day;
    
   public ErrorHandling_AccountInfo(User localUser){
    
    this.user = localUser;
    
    String [] dateSplit = this.user.getDob().split("-");
    this.year = dateSplit[0];
    this.month = dateSplit[1];
    this.day = dateSplit[2];
}
   
   int ErrorCheck_AccountInfo(){
       
       try{
           if(Integer.parseInt(this.year) < 0 || Integer.parseInt(this.month) < 0 || Integer.parseInt(this.day) < 0 ){
               
               JOptionPane.showMessageDialog(null, "Invalid date"
                    , "Invalid Date of birth : ", JOptionPane.ERROR_MESSAGE);
            
            return 1;
           }
           
       }
       
       catch (Exception e){
           
           JOptionPane.showMessageDialog(null, "Invalid date"
                    , "Invalid Date of birth : ", JOptionPane.ERROR_MESSAGE);
           
           return 1;
           
       }
    
   
    
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
        }
        catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "Please put valid date"
                    , "Invalid Date: ", JOptionPane.ERROR_MESSAGE);
            
            
        }
        
       return 0;
       
   }
   
   String [] DateCleanUp(){
       
       String [] monthAndDay = {this.month,this.year};
       
       if(Integer.parseInt(this.month)<10 && !"0".equals(this.month.substring(0,1)) ){
            
            //add 0 to month number to avoid any date errors
            
            this.month = "0" + this.month;
            monthAndDay[0] = this.month;
            
        }
        
        if(Integer.parseInt(this.day)<10 && !"0".equals(this.day.substring(0,1)) ){
            
            //add 0 to day number to avoid any date errors 
            this.day = "0" + this.day;
            monthAndDay[1] = this.day;
            
        }
        
        return monthAndDay;
   }
    
}
