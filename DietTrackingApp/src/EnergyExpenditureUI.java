import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class EnergyExpenditureUI extends JFrame {
    private JTextField startDateField, endDateField;
    private JButton analyzeButton;
    private int accountID;
    private SQLConnection sqlConnection;

    public EnergyExpenditureUI(int accountID) {
        this.accountID = accountID;
        this.sqlConnection = new SQLConnection();
        setTitle("Daily Calory Intake VS Daily Energy Expenditure");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        startDateField = new JTextField(10);
        endDateField = new JTextField(10);

        analyzeButton = new JButton("Analyze Diet");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeDiet();
            }
        });

        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2)); // Grid should be 3x2, since we have 3 rows of labels and text fields

        inputPanel.add(new JLabel("Start date (yyyy-MM-dd):"));
        inputPanel.add(startDateField);
        inputPanel.add(new JLabel("End date (yyyy-MM-dd):"));
        inputPanel.add(endDateField);
        inputPanel.add(analyzeButton);

        add(inputPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void analyzeDiet() {
        String startDateText = startDateField.getText();
        String endDateText = endDateField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Connection connect = null;

        try {
            Date startDate = dateFormat.parse(startDateText);
            Date endDate = dateFormat.parse(endDateText);
            if (startDate.after(endDate)) {
                JOptionPane.showMessageDialog(this, "Start date must be before end date", "Date Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            connect = sqlConnection.SQLConnect();
            String q1 = "SELECT SUM(TotalCalories) as TotalIntake FROM calories_intake_info WHERE Date BETWEEN ? AND ? AND AccountID = ?";
            String q2 = "SELECT SUM(CaloriesBurnedTotal) as TotalBurned FROM calories_total WHERE Date BETWEEN ? AND ? AND AccountID = ?";

            double totalIntake = queryForTotal(connect, q1, startDate, endDate, accountID);
            double totalBurned = queryForTotal(connect, q2, startDate, endDate, accountID);

            displayChart(totalIntake, totalBurned);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd", "Date Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private double queryForTotal(Connection connect, String query, Date startDate, Date endDate, int accountID) throws SQLException {
        try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(startDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));
            preparedStatement.setInt(3, accountID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble(1);
                }
            }
        }
        return 0;
    }

    private void displayChart(double totalIntake, double totalBurned) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(totalIntake, "Calorie Intake", "Total Intake");
        dataset.addValue(totalBurned, "Energy Expenditure", "Total Burned");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Calorie Intake vs Energy Expenditure",
                "Category",
                "Calories",
                dataset);

     /*   CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesPaint(1, Color.green);
*/
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        JFrame chartFrame = new JFrame("Calorie Analysis");
        chartFrame.setContentPane(chartPanel);
        chartFrame.pack();
        chartFrame.setLocationRelativeTo(null);
        chartFrame.setVisible(true);
    }
}
