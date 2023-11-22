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
		String query = "SELECT * FROM diet_data WHERE AccountID = ?";
		try (Connection connect = sqlConnection.SQLConnect()) {
			PreparedStatement pstmt = connect.prepareStatement(query);
  
                pstmt.setInt(1, AccountID);
                ResultSet rs = pstmt.executeQuery();
                    
                while (rs.next()) {
                	DietData dietData = new DietData();
                	
                	dietData.setNutrientValue(rs.getDouble("NutrientValue"));
                	dietData.setNutrientName(rs.getString("NutrientName"));
                	
                	dietDataList.add(dietData);
                }
        }
        catch (SQLException e) {
           System.out.println(e);
        }
        return dietDataList;
	}

}
