


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

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
    private String dob;
    private User user;
    
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
    
    public AccountSetUp(int accNum,String firstName, String lastName, int age,  double weight, double height, String sex) {
        
       this.accountNum = accNum;
       this.firstName =firstName;
       this.lastName = lastName;
       this.age = age;
       this.weight = weight;
       this.height = height;
       this.sex = sex;
       
       
       
    }
    
    public AccountSetUp(int accNum,String firstName, String lastName, int age,  double weight, double height, String sex, String units, String dob) {
        
       this.accountNum = accNum;
       this.firstName =firstName;
       this.lastName = lastName;
       this.age = age;
       this.weight = weight;
       this.height = height;
       this.sex = sex;
       this.units =  units;
       this.dob = dob;
       
       
    }
    
    public AccountSetUp(User localUser) {
        this.user = localUser;
    }
    
    

    public AccountSetUp() {
        
    }

    @Override
    public void AddAccount(){
        
        try {
             
           // Class.forName("com.mysql.cj.jdbc.Driver");
           // Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
            
           SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
           
           
           
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
                
                this.accountNum = 1;
                
                System.out.println("no profile");
            }
            
            
            
            
            //String sqlADD = "INSERT INTO INFO VALUES('4','1','1','1','1','1','1')";
            String sqlADD = "INSERT INTO INFO VALUES ("+this.accountNum+", '"+this.firstName+"', '"+this.lastName+"', '"+this.age+"','"+this.weight+"','"+this.height+"','"+this.sex+"','Metric','"+this.dob+"')";

            
            stm.executeUpdate(sqlADD);
            
            //String sqlAddSettings = "INSERT INTO Settings VALUES ("+this.accountNum+", 'metric')";
            
            //stm.executeUpdate(sqlAddSettings);
            
        
           
           
           
         }catch (Exception e){
             
             System.out.println("Hey we fucked up");
             
         }
       
        
        
        
        
    }
    
    @Override
    public void UpdateAccount(){
        
        try{
             
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
           
              SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
            
            
            PreparedStatement update = connect.prepareStatement("UPDATE INFO SET userFirstName = ?, userLastName = ?, userAge = ?, userWeight = ?, userHeight = ?, userSex = ?, userDOB = ? WHERE AccountID = ?;");
           
           
           update.setString(1,this.firstName);
           update.setString(2,this.lastName);
           update.setInt(3,this.age);
           update.setDouble(4,this.weight);
           update.setDouble(5,this.height);
           update.setString(6,this.sex);
           update.setInt(7,this.accountNum);
           update.setString(8, this.dob);
           

           update.executeUpdate();
           
           System.out.println("We did it!");
           
            
           
           
           
         }catch (Exception e){
             System.out.println("We didnt do it....");
         }
       
        
    }

    @Override
    public String [] GetAllAccounts() {
        
        String QUERY = "SELECT AccountID, userFirstName FROM INFO";
        
        String [] accountList = new String[10];
         
        
        try{
        
        //Class.forName("com.mysql.cj.jdbc.Driver");
           // Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
            
             SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
           
            Statement stm = connect.createStatement();
            
            //find max number of accounts 
            
           String sql2 = "SELECT AccountID FROM INFO";
           String sql3 = "SELECT Max(AccountID) FROM INFO";
           
           
            
            ResultSet rs = stm.executeQuery(sql2);
            
            System.out.println("passed lvl1");
            
            if(rs.next()){
                
                //if we have an account, find the max ID
                System.out.println("passed lvl2");
                
                ResultSet rs1Max = stm.executeQuery(sql3);
                rs1Max.next();
                this.accountNum = rs1Max.getInt("Max(AccountID)");
                System.out.println("passed lvl3");
                System.out.println(this.accountNum);
                
                
                

            } else {
                //if no previous account, we will return no accounts
                System.out.println("weird");
                this.accountNum = 0;
                
                return accountList;
            }
            
            
          
            
           ResultSet rsGet = stm.executeQuery(QUERY);
           accountList = new String [this.accountNum];
           
            //get all the accounts and put them in an String list
            for(int i=0;i<this.accountNum;i++){
            //Display values
            rsGet.next();
            System.out.println("ID: " + rsGet.getInt("AccountID"));
            System.out.println(rsGet.getString("userFirstName"));
            accountList[i] = rsGet.getString("userFirstName");
            
            }
            
         
            return accountList;
            
            
            
        } catch (Exception e){
            
            System.out.println("something went wrong");
        }
        
        
        return accountList;
        
    }

    @Override
    public User getSelectedAccount(int accountId) {
        
        String query = "SELECT userFirstName, userLastName, userAge, userWeight, userHeight, userSex, userUnits, userDOB FROM INFO WHERE AccountID = "+accountId+";";
        User accSelect = new User();
          try{
             
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
           
              SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
            
            
           Statement stmt = connect.createStatement();
           ResultSet rs = stmt.executeQuery(query);
           
           
         
          rs.next();
           
           System.out.println(rs.getString("userLastName"));
           
       this.accountNum = accountId;
       this.firstName =rs.getString("userFirstName");
       this.lastName = rs.getString("userLastName");
       this.age = rs.getInt("userAge");
       this.weight = rs.getDouble("userWeight");
       this.height = rs.getDouble("userHeight");
       this.sex = rs.getString("userSex");
       this.units =  rs.getString("userUnits");
       this.dob = rs.getString("userDOB");
       
       System.out.println(this.weight);
       System.out.println(this.units);
       
           
           
            accSelect = new User(this.accountNum,
       this.firstName,
       this.lastName,
       this.age,
       this.weight,
       this.height,
       this.sex,
       this.units,
       this.dob);
           
           
           
         }catch (Exception e){
             System.out.println("We didnt do it bb....");
             
         }
        
        return accSelect;
        
        
    }

    @Override
    public void UpdateAge() {
        
        try{
             
              SQLConnection sqlConnect = new SQLConnection();
              Connection connect = sqlConnect.SQLConnect();
              
              PreparedStatement update = connect.prepareStatement("UPDATE INFO SET userAge = ? WHERE AccountID = ?;");
           
        
        LocalDate userDob = LocalDate.parse(this.dob);
        LocalDate currentDate = LocalDate.now();
        
        Period period = Period.between(userDob,currentDate);
        
         this.age = period.getYears();
          
        
        update.setInt(1,this.age);
          
           

           update.executeUpdate();
           
           System.out.println("We did it!");
           
            
           
           
           
         }catch (Exception e){
             System.out.println("We didnt do it....");
         }
       


    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }
    
    
}
