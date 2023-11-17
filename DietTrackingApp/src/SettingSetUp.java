
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class SettingSetUp implements SettingsInterface {

    
    private final User user;

    
    
    SettingSetUp(User localUser) {
        
    this.user = localUser;
}

    @Override
    public void MetricSetting() {
          try{
      SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
          
            Statement stm = connect.createStatement();
            
             String sql = "update INFO set userUnits = 'Metric' where AccountID in ("+this.user.getAccID()+");";
             stm.executeUpdate(sql);
         
             System.out.println("we did it?");
    
}catch (Exception e){
    
}
    }

    @Override
    public void ImperialSetting() {
          try{
          SQLConnection sqlConnect = new SQLConnection();
          Connection connect = sqlConnect.SQLConnect();
          
            Statement stm = connect.createStatement();
            
            System.out.println("we connected");
            
             String sql = "update INFO set userUnits = 'Imperial' where AccountID in ("+this.user.getAccID()+");";
             stm.executeUpdate(sql);
             
             System.out.println("we did it?");
         
    
}catch (Exception e){
    
}     }
    
}
