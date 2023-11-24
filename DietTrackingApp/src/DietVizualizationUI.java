import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class DietVizualizationUI {

    private JFrame frame;
    private int accountID;

    public DietVizualizationUI(int accountID) {
        this.accountID = accountID;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Diet Alignment UI");
        frame.setLayout(new BorderLayout());
        
        // Add the chart panel
        JFreeChart UserAvgPlateChart = generateAveragePlateChart();
        JFreeChart CFGChart = generateCFGRecommendations();
        
        ChartPanel chartPanel = new ChartPanel(UserAvgPlateChart);
        chartPanel.setPreferredSize(new Dimension(600, 500));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		
        ChartPanel chartPanel2 = new ChartPanel(CFGChart);
        chartPanel2.setPreferredSize(new Dimension(600, 500));
		chartPanel2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel2.setBackground(Color.white);
        frame.add(chartPanel, BorderLayout.CENTER);

        // Add CFG recommendation button
        JButton cfgButton = new JButton("Show CFG Recommendations");
        cfgButton.addActionListener(e -> showCFGRecommendations(frame, chartPanel, chartPanel2));
        frame.add(cfgButton, BorderLayout.SOUTH);

        // Frame configurations
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JFreeChart generateAveragePlateChart() {
        DietDataService dietDataService = new DietDataService(this.accountID);
        return dietDataService.generateAveragePlate();
    }
    private JFreeChart generateCFGRecommendations() {
        DietDataService dietDataService = new DietDataService(this.accountID);
        return dietDataService.generateCFGRecommendations();
    }
    

    private void showCFGRecommendations(JFrame frame, ChartPanel userAvgPlate, ChartPanel CFG) {
    	frame.getContentPane().removeAll();
		frame.add(userAvgPlate, BorderLayout.WEST);
		frame.add(CFG, BorderLayout.EAST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
    }
}



