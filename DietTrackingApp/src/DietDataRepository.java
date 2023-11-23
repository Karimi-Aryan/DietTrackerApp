import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DietDataRepository implements DietDataInterface {

    private SQLConnection sqlConnection;
    
    public DietDataRepository() {
    	this.sqlConnection = new SQLConnection(); // Create a new SQLConnection instance
    }
	
    @Override
	public List<DietData> findByAccountID(int AccountID) {
		List<DietData> dietDataList = new ArrayList<>();
		String query = "SELECT FoodGroupName, COUNT(*) as Count FROM meal_info WHERE AccountID = ? GROUP BY FoodGroupName";
		try (Connection connect = sqlConnection.SQLConnect()) {
			PreparedStatement pstmt = connect.prepareStatement(query);
  
                pstmt.setInt(1, AccountID);
                ResultSet rs = pstmt.executeQuery();
                    
                while (rs.next()) {
                	DietData dietData = new DietData();
                	
                	dietData.setFoodGroupCount(rs.getDouble("Count"));
                	dietData.setFoodGroupName(rs.getString("FoodGroupName"));
                	
                	dietDataList.add(dietData);
                }
        }
        catch (SQLException e) {
           System.out.println(e);
        }
        return dietDataList;
	}

}
