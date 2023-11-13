/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class BMRCalculator implements BMRInterface {
    
    double bmrFinal= 0;
    
    
    public BMRCalculator(){
    
}
    
    @Override
    public int BMRCalc (double height, double weight, int age, String sex, String units){
        
      
        if (sex.equals("Male")){
            
            if(units.equals("Metric")){

        //Men: BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) – (5.677 x age in years)
        
         bmrFinal = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        
            }
            else if (units.equals("Imperial")){
                
                bmrFinal = 66.47 + ( 6.24 * weight) + ( 12.7 * height) - ( 6.755 * age);
                
                

                
                
            }
       
        } else if (sex.equals("Female")){
        //Women: BMR = 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) – (4.330 x age in years)
        
        if(units.equals("Metric")){
         bmrFinal = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        
        
        }
        else if (units.equals("Imperial")){
                
                bmrFinal = 655.1 + ( 4.35 *weight) + ( 4.7 *height) - ( 4.676 * age);
                
            }
    
    }
        bmrFinal = Double.parseDouble(String.format("%.2f", bmrFinal));
        
      return  (int) Math.round(bmrFinal); 
    }
}
