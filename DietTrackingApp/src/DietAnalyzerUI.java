import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

// Class representing the user interface for diet analysis
public class DietAnalyzerUI extends JFrame {

    private JTextField startDateField, endDateField;
    private JButton analyzeButton;
    private JComboBox<String> nutrientCountComboBox;
    private int accountID;

    public DietAnalyzerUI(int accountID) {
        this.accountID = accountID;

        setTitle("Diet Analyzer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        startDateField = new JTextField(10);
        endDateField = new JTextField(10);
        nutrientCountComboBox = new JComboBox<>(new String[]{"Top 5", "Top 10"});

        analyzeButton = new JButton("Analyze Diet");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeDiet();
            }
        });
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Start date (yyyy-MM-dd):"));
        inputPanel.add(startDateField);
        inputPanel.add(new JLabel("End date (yyyy-MM-dd):"));
        inputPanel.add(endDateField);
        inputPanel.add(new JLabel("Nutrients:"));
        inputPanel.add(nutrientCountComboBox);
        inputPanel.add(analyzeButton);

        add(inputPanel, BorderLayout.CENTER);

        // Add the button to the south (bottom) of the frame
        add(analyzeButton, BorderLayout.SOUTH);

        // Make the frame center on the screen
        setLocationRelativeTo(null);

        setVisible(true); // Set the frame as visible
    }

    private void analyzeDiet() {
        String startDateText = startDateField.getText();
        String endDateText = endDateField.getText();
        int nutrientCount = nutrientCountComboBox.getSelectedIndex() == 0 ? 5 : 10;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateFormat.parse(startDateText);
            endDate = dateFormat.parse(endDateText);

            // Check if start date is before end date
            if (startDate.after(endDate)) {
                JOptionPane.showMessageDialog(this, "Start date must be before end date", "Date Validation Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further processing
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd", "Date Validation Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing
        }

        // Get top nutrients and their percentages using NutrientAnalyzer
        NutrientAnalyzer nutrientAnalyzer = new NutrientAnalyzer();
        Map<String, Double> nutrientPercentages = nutrientAnalyzer.getTopNutrients(startDateText, endDateText, nutrientCount, this.accountID);
        for (Map.Entry<String, Double> entry : nutrientPercentages.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
        }

        // Uncomment the following code if using JFreeChart for pie chart visualization
        /*
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry : nutrientPercentages.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Nutrient Distribution",
                dataset,
                true,
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        chartPanel.setChart(chart);
        */

        // Close the connection when done
        nutrientAnalyzer.closeConnection();
    }
}
