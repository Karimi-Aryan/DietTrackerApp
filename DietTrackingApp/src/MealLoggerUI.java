import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class representing the user interface for logging meals
public class MealLoggerUI extends javax.swing.JFrame{

    // Components for the UI
    private JComboBox<String> mealTypeComboBox;
    private JTextField mealNameTextField;
    private JTextField logDateTextField;
    private MealValidator mealValidator;
    private MealLogger mealLogger;
    private int accountID;


    // Constructor to initialize the UI
    public MealLoggerUI(User localUser) {
        mealValidator = new MealValidator(); // Initialize the meal validator
        mealLogger = new MealLogger();
        accountID = localUser.getAccID();



        // Set up the frame
        setTitle("Meal Logger");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);

        // Create components
        mealTypeComboBox = new JComboBox<>(new String[]{"Breakfast", "Lunch", "Dinner", "Snacks"});
        mealNameTextField = new JTextField(20);
        logDateTextField = new JTextField(10);

        // Button to log the meal
        JButton logButton = new JButton("Log Meal");
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logMeal(); // Call the method to log the meal when the button is clicked
            }
        });

        // Set layout to a BorderLayout
        setLayout(new BorderLayout());

        // Create a panel for the components
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // Add components to the panel
        inputPanel.add(new JLabel("Meal Type:"));
        inputPanel.add(mealTypeComboBox);
        inputPanel.add(new JLabel("Meal Name:"));
        inputPanel.add(mealNameTextField);
        inputPanel.add(new JLabel("Date (yyyy-MM-dd):"));
        inputPanel.add(logDateTextField);

        // Add the panel to the center of the frame
        add(inputPanel, BorderLayout.CENTER);

        // Add the button to the south (bottom) of the frame
        add(logButton, BorderLayout.SOUTH);

        // Make the frame center on the screen
        setLocationRelativeTo(null);

        setVisible(true); // Set the frame as visible
    }

    // Method to handle the logging of a meal
    private void logMeal() {
        // Retrieve input values
        String mealType = (String) mealTypeComboBox.getSelectedItem();
        String mealName = mealNameTextField.getText();
        String logDate = logDateTextField.getText();

        // Validate input using MealValidator
        // Check if the meal type is valid
        if (!mealValidator.isValidMealType(mealType)) {
            JOptionPane.showMessageDialog(this, "Invalid meal type. Please select a valid meal type.");
            return;
        }

        // Check if the meal name is valid
        if (!mealValidator.isValidMealName(mealName)) {
            JOptionPane.showMessageDialog(this, "Invalid meal name. Please enter a valid meal name.");
            return;
        }

        // Check if the date is valid
        if (!mealValidator.isValidDate(logDate)) {
            JOptionPane.showMessageDialog(this, "Invalid date. Please use the format: yyyy-MM-dd");
            return;
        }
        if (!mealType.equals("Snacks")) {
            if (entryExistsForMealType(mealType, logDate, accountID)) {
                JOptionPane.showMessageDialog(this, "Entry for " + mealType + " already exists on " + logDate + ". Cannot log another entry.");
                return;
            }
        }

        // If all input is valid, proceed to log the meal

        boolean isMealLogged = mealLogger.logMeal(this.accountID, mealType, mealName, logDate);

        // Display success message if the meal is logged successfully
        if (isMealLogged) {
            JOptionPane.showMessageDialog(this, "Meal logged successfully!");
        }
        dispose(); // Close the frame after a successful meal log

        mealValidator.closeConnections();
        mealLogger.closeConnections();

    }
    private boolean entryExistsForMealType(String mealType, String date, int accountID) {
        MealLogger mealLogger = new MealLogger();
        boolean entryExists = mealLogger.entryExistsForMealType(mealType, date, accountID);
        mealLogger.closeConnections();
        return entryExists;
    }
}

