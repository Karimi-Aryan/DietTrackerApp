
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class SQLConnection implements ConnectionInterface {
    
    public SQLConnection() {
        
}

    @Override
    public Connection SQLConnect() {
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/eecs3311_d2","root","password");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connect;
    }
    
    
}
