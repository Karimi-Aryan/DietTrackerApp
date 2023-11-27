import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author aryankarimi
 */
public class SettingSetUp implements SettingsInterface {
    private final User user;
    SettingSetUp(User localUser) {
        this.user = localUser;
    }
    @Override
    public void MetricSetting() {
        try {
            SQLConnection sqlConnect = new SQLConnection();
            Connection connect = sqlConnect.SQLConnect();
            Statement stm = connect.createStatement();
            if (this.user.getUnits().equals("Metric")) {
                return;
            }
            String sql = "update account_info set userUnits = 'Metric' where AccountID in (" + this.user.getAccID() + ");";
            stm.executeUpdate(sql);
            PreparedStatement update = connect.prepareStatement("UPDATE account_info SET userWeight = ?, userHeight = ? WHERE AccountID = ?;");
            update.setDouble(1, Math.round((this.user.getWeight() * 2.2046) * 100.0) / 100.0);
            update.setDouble(2, Math.round((this.user.getHeight() * 0.3937) * 100.0) / 100.0);
            update.executeUpdate();
            connect.close();
        } catch (Exception e) {
        }
    }
    @Override
    public void ImperialSetting() {
        try {
            SQLConnection sqlConnect = new SQLConnection();
            Connection connect = sqlConnect.SQLConnect();
            Statement stm = connect.createStatement();
            if (this.user.getUnits().equals("Imperial")) {
                return;
            }
            String sql = "update account_info set userUnits = 'Imperial' where AccountID in (" + this.user.getAccID() + ");";
            stm.executeUpdate(sql);
            PreparedStatement update = connect.prepareStatement("UPDATE account_info SET userWeight = ?, userHeight = ? WHERE AccountID = ?;");
            update.setDouble(1, Math.round((this.user.getWeight() * 0.4536) * 100.0) / 100.0);
            update.setDouble(2, Math.round((this.user.getHeight() * 2.54) * 100.0) / 100.0);
            update.executeUpdate();
            connect.close();
        } catch (Exception e) {
        }
    }
}
