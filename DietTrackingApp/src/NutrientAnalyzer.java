import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class NutrientAnalyzer {
    // Database connection field
    private Connection connection;

    // Constructor to initialize the database connection
    public NutrientAnalyzer() {
        try {
            // Establish a database connection using SQLConnection class
            SQLConnection sqlConnect = new SQLConnection();
            this.connection = sqlConnect.SQLConnect();
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
        }
    }

    // Method to retrieve the top nutrients and their percentages for a given date range
    public Map<String, Double> getTopNutrients(String startDate, String endDate, int nutrientCount, int accountID) {
        Map<String, Double> nutrientPercentages = new HashMap<>();

        try {
            // Prepare SQL query to get top nutrients and their total values
            String query = "SELECT NutrientName, SUM(NutrientValue) as TotalValue " +
                    "FROM user_diet " +
                    "WHERE LogDate BETWEEN ? AND ? " +
                    "AND NutrientUnit = 'g' " +
                    "AND AccountID = ? " +
                    "GROUP BY NutrientName " +
                    "ORDER BY TotalValue DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, startDate);
            preparedStatement.setString(2, endDate);
            preparedStatement.setInt(3, accountID);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set and store data in a list of maps
            List<Map<String, Object>> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("NutrientName", resultSet.getString("NutrientName"));
                row.put("TotalValue", resultSet.getDouble("TotalValue"));
                resultList.add(row);
            }

            // Calculate total value of all nutrients
            double totalValue = 0.0;
            for (Map<String, Object> row : resultList) {
                totalValue += (Double) row.get("TotalValue");
            }

            // Calculate percentage for each nutrient
            int topNutrientCount = Math.min(nutrientCount, resultList.size());
            for (int i = 0; i < topNutrientCount; i++) {
                Map<String, Object> row = resultList.get(i);
                String nutrientName = (String) row.get("NutrientName");
                double nutrientValue = (Double) row.get("TotalValue");
                double percentage = (nutrientValue / totalValue) * 100.0;

                // Round the percentage to two decimal places
                double roundedPercentage = Math.round(percentage * 100.0) / 100.0;
                nutrientPercentages.put(nutrientName, roundedPercentage);
            }

            // Calculate percentage for "Other" category
            double otherPercentage = 100.0 - nutrientPercentages.values().stream().mapToDouble(Double::doubleValue).sum();
            // Ensure the "Other" percentage is within the valid range of 0% to 100%
            otherPercentage = Math.max(0.0, Math.min(100.0, otherPercentage));
            // Round the percentage for "Other" to two decimal places
            otherPercentage = Math.round(otherPercentage * 100.0) / 100.0;
            nutrientPercentages.put("Other", otherPercentage);

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
        }

        return nutrientPercentages; // Return the map of nutrient percentages
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            // Check if the connection is open before attempting to close
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
        }
    }
}
