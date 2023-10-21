
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class AccountSetUp implements AccountInterface {

    private int accountNum;
    private  String firstName;
    private  String lastName;
    private  int age;
    private  double weight;
    private  double height;
    private  String sex;
    private  String units;
    
    public AccountSetUp(int accNum,String firstName, String lastName, int age,  double weight, double height, String sex, String units) {
        
       this.accountNum = accNum;
       this.firstName =firstName;
       this.lastName = lastName;
       this.age = age;
       this.weight = weight;
       this.height = height;
       this.sex = sex;
       this.units =  units;
       
       
    }

    @Override
    public void AddAccount(){
        
        try {
             
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
            
            Statement stm = connect.createStatement();
           
           //check what id is the last one
           
           
           String sql2 = "SELECT AccountID FROM INFO";
           String sql3 = "SELECT Max(AccountID) FROM INFO";
           
           
            
            ResultSet rs = stm.executeQuery(sql2);
            
            if(rs.next()){
                
                //if we have an account, find the max ID
                
                System.out.println("we have a profile");
                
                ResultSet rs1Max = stm.executeQuery(sql3);
                rs1Max.next();
                this.accountNum = rs1Max.getInt("Max(AccountID)") + 1;
                
                System.out.println(rs1Max.getInt("Max(AccountID)"));
                System.out.println(this.accountNum);

            } else {
                //if no previous account, we make the first one
                
                this.accountNum = 0;
                
                System.out.println("no profile");
            }
            
            
            
            
            //String sqlADD = "INSERT INTO INFO VALUES('4','1','1','1','1','1','1')";
            String sqlADD = "INSERT INTO INFO VALUES ("+this.accountNum+", '"+this.firstName+"', '"+this.lastName+"', '"+this.age+"','"+this.weight+"','"+this.height+"','"+this.sex+"')";

            
            stm.executeUpdate(sqlADD);
            
            String sqlAddSettings = "INSERT INTO Settings VALUES ("+this.accountNum+", 'metric')";
            
            stm.executeUpdate(sqlAddSettings);
            
        
           
           
           
         }catch (Exception e){
             
             System.out.println("Hey we fucked up");
             
         }
       
        
        
        
        
    }
    
    @Override
    public void UpdateAccount(){
        
        try{
             
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
           
            PreparedStatement update = connect.prepareStatement("UPDATE INFO SET userFirstName = ?, userLastName = ?, userAge = ?, userWeight = ?, userHeight = ?, userSex = ? WHERE AccountID = ?;");
           
           
           update.setString(1,this.firstName);
           update.setString(2,this.lastName);
           update.setInt(3,this.age);
           update.setDouble(4,this.weight);
           update.setDouble(5,this.height);
           update.setString(6,this.sex);
           update.setInt(7,this.accountNum);
           

           update.executeUpdate();
           
           System.out.println("We did it!");
           
            
           
           
           
         }catch (Exception e){
             System.out.println("We didnt do it....");
         }
       
        
    }
    
}
