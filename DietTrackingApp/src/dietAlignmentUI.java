import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
​
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
​
import javax.swing.*;
​
public class dietAlignmentUI {
​
	public static void main(String[] args) {
			JFrame frame = new JFrame();
			
			//Set Title
			frame.setTitle("Diet Alignment UI");
			
			//Add pie chart to the frame
			frame.add(createChartPanel1(), BorderLayout.CENTER);
			
			//Add button to compare with CFG recommendations
			JButton Button = new JButton("Compare with Canada Food Guide Recommendation");
			Button.addActionListener(e -> showCFGChart(frame));
			frame.add(Button, BorderLayout.SOUTH);
			
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
	}
	
	//Button behavior
	private static void showCFGChart(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.add(createChartPanel1(), BorderLayout.WEST);
		frame.add(createChartPanel2(), BorderLayout.EAST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	//Create panel for chart
	private static JPanel createChartPanel1() {
		JFreeChart chart = createChart1();
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(600, 500));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
        return chartPanel;
	}
	private static JPanel createChartPanel2() {
		JFreeChart chart = createChart2();
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(600, 500));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
        return chartPanel;
	}
	
	//Create piechart(s) using dataset(s)
	private static JFreeChart createChart1() {
		JFreeChart pieChart = ChartFactory.createPieChart("User's average plate", createDataset1(), true, true, false);
		return pieChart;
	}
	private static JFreeChart createChart2() {
		JFreeChart pieChart = ChartFactory.createPieChart("Canada Food Guide Recommendation", createDataset2(), true, true, false);
		return pieChart;
	}
​
	//Create dataset
	private static DefaultPieDataset<String> createDataset1() {
		DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
		dataset.setValue("Dairy and Egg Products", 25);
		dataset.setValue("Poultry Products", 28);
		dataset.setValue("Spices and Herbs", 9);
		dataset.setValue("Babyfoods", 2);
		dataset.setValue("Fats and Oils", 15);
		dataset.setValue("Soups, Sauces and Gravies", 10);
		dataset.setValue("Breakfast cereals", 6);
		dataset.setValue("Fruits and fruit juices", 5);
		return dataset;
	}
	private static DefaultPieDataset<String> createDataset2() {
		DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
		dataset.setValue("Dairy and Egg Products", 2);
		dataset.setValue("Poultry Products", 1);
		dataset.setValue("Spices and Herbs", 2);
		dataset.setValue("Babyfoods", 0.5);
		dataset.setValue("Fats and Oils", 0.5);
		dataset.setValue("Soups, Sauces and Gravies", 2);
		dataset.setValue("Breakfast cereals", 1);
		dataset.setValue("Fruits and fruit juices", 2);
		return dataset;
​
	}