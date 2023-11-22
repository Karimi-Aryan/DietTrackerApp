
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

//AccountHomePage home = new AccountHomePage(user);
//home.HomePageUI(user);

//Create Account

 CreateAccountUI account = new CreateAccountUI();
        account.CreateAccUI();
        
        //BMR calculation
        
        //BMRcalculation bmr = new BMRcalculation(user); 
        //bmr.BMRCalc(user);
    
}
}
