


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
    private String accInfo_Table = "account_info";
    
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
           
           
           String sql2 = "SELECT AccountID FROM "+accInfo_Table+"";
           String sql3 = "SELECT Max(AccountID) FROM "+accInfo_Table+"";
           
           
            
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
                
                
            }
            
            
            
            
            //String sqlADD = "INSERT INTO INFO VALUES('4','1','1','1','1','1','1')";
            String sqlADD = "INSERT INTO "+accInfo_Table+" VALUES ("+this.accountNum+", '"+this.firstName+"', '"+this.lastName+"', '"+this.age+"','"+this.weight+"','"+this.height+"','"+this.sex+"','Metric','"+this.dob+"')";

            
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
            
            
            PreparedStatement update = connect.prepareStatement("UPDATE "+accInfo_Table+" SET userFirstName = ?, userLastName = ?, userAge = ?, userWeight = ?, userHeight = ?, userSex = ?, userDOB = ? WHERE AccountID = ?;");
           
           
           update.setString(1,this.firstName);
           update.setString(2,this.lastName);
           update.setInt(3,this.age);
           update.setDouble(4,this.weight);
           update.setDouble(5,this.height);
           update.setString(6,this.sex);
           update.setInt(7,this.accountNum);
           update.setString(8, this.dob);
           

           update.executeUpdate();
           
           
           
            
           
           
           
         }catch (Exception e){
             System.out.println("We didnt do it....");
         }
       
        
    }

    @Override
    public String [] GetAllAccounts() {
        
        String QUERY = "SELECT AccountID, userFirstName FROM "+accInfo_Table+"";
        
        String [] accountList = new String[10];
         
        
        try{
        
        //Class.forName("com.mysql.cj.jdbc.Driver");
           // Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
            
             SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
           
            Statement stm = connect.createStatement();
            
            //find max number of accounts 
            
           String sql2 = "SELECT AccountID FROM "+accInfo_Table+"";
           String sql3 = "SELECT Max(AccountID) FROM "+accInfo_Table+"";
           
           
            
            ResultSet rs = stm.executeQuery(sql2);
            
            
            
            if(rs.next()){
                
                //if we have an account, find the max ID
               
                
                ResultSet rs1Max = stm.executeQuery(sql3);
                rs1Max.next();
                this.accountNum = rs1Max.getInt("Max(AccountID)");
               
                
                
                

            } else {
                //if no previous account, we will return no accounts
                
                this.accountNum = 0;
                
                return accountList;
            }
            
            
          
            
           ResultSet rsGet = stm.executeQuery(QUERY);
           accountList = new String [this.accountNum];
           
            //get all the accounts and put them in an String list
            for(int i=0;i<this.accountNum;i++){
            //Display values
            rsGet.next();
           
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
        
        String query = "SELECT userFirstName, userLastName, userAge, userWeight, userHeight, userSex, userUnits, userDOB FROM "+accInfo_Table+" WHERE AccountID = "+accountId+";";
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
             
            System.out.println("something went wrong"); 
         }
        
        return accSelect;
        
        
    }

    @Override
    public void UpdateAge() {
        
        try{
             
              SQLConnection sqlConnect = new SQLConnection();
              Connection connect = sqlConnect.SQLConnect();
              
              PreparedStatement update = connect.prepareStatement("UPDATE "+accInfo_Table+" SET userAge = ? WHERE AccountID = ?;");
       
        
        LocalDate userDob = LocalDate.parse(this.user.dob);
        
         
        LocalDate currentDate = LocalDate.now();
         
        Period period = Period.between(userDob,currentDate);
         
         this.user.setAge(period.getYears());
          
          
        
        update.setInt(1,this.user.getAge());
        update.setInt(2, this.user.getAccID());
          
           

           update.executeUpdate();
           
          
           
            
           
           
           
         }catch (Exception e){
             System.out.println("We didnt do it....go fix AccountSetUp updateAge()");
              System.out.println(this.age);
             
         }
       


    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }
    
    
}
