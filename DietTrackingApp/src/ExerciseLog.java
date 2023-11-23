

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ExerciseLog extends javax.swing.JFrame implements ActionListener{
	
JFrame frame = new JFrame("Exercise Log");
JTextField fDate = new JTextField();
JTextField fMonth = new JTextField();
JTextField fYear = new JTextField();
JTextField exerciseDuration = new JTextField();
JComboBox<String> typesExercises;
JComboBox<String> intensityType;
JButton Save = new JButton("Save");
JButton Back = new JButton("Back");
private static final long serialVersionUID = 1L;
private User user;


public ExerciseLog(User user) {
	this.user = user;	
}
public void ExerciseLogUI() {
	JLabel typeofExercise = new JLabel("What exercise do you want to log?");
	typeofExercise.setBounds(30, 10, 400, 100);
	
	Vector<String> exercises = new Vector<String>();
	exercises.add("walking");
	exercises.add("jogging");
	exercises.add("bicycling");
	exercises.add("cleaning");
	exercises.add("dishwashing");
	exercises.add("sitting");
	exercises.add("weight_training");
	exercises.add("mowing_lawn");
	exercises.add("football");
	exercises.add("basketball");

	typesExercises = new JComboBox<String>(exercises);
	typesExercises.setBounds(30, 80, 100, 20);
	typesExercises.addActionListener(this);
	
	JLabel dateofExercise = new JLabel("Give the date you exercised (YYYY/MM/DD): ");
	dateofExercise.setBounds(30, 80, 400, 100);
	

	JLabel fromLabel = new JLabel("Date:");
	fromLabel.setBounds(30, 145, 40, 20);
	
	fYear.setBounds(30, 170, 40, 25);
	JLabel fYearSlash = new JLabel("/");
	fYearSlash.setBounds(70, 170, 30, 25);
	
	fMonth.setBounds(80, 170, 30, 25);
	JLabel fMonthSlash = new JLabel("/");
	fMonthSlash.setBounds(110, 170, 30, 25);
	
	fDate.setBounds(120, 170, 30, 25);

	JLabel DurationLabel = new JLabel("Duration (in hours):");
	DurationLabel.setBounds(175, 145, 150, 20);
	
	exerciseDuration.setBounds(175, 170, 40, 30);
	
	
	JLabel intensityofExercise = new JLabel("How would you describe your intensity during this period?");
	intensityofExercise.setBounds(30, 165, 400, 100);
	
	Vector<String> intensity = new Vector<String>();
	intensity.add("Easy");
	intensity.add("Medium");
	intensity.add("Hard");
	intensity.add("Very hard");	
	
	intensityType = new JComboBox<>(intensity);
	intensityType.setBounds(30, 235, 100, 20);
	intensityType.addActionListener(this);
	
	Save.setBounds(30, 300, 90, 20);
	Save.addActionListener(this);
    
	Back.setBounds(180, 300, 90, 20);
	Back.addActionListener(this);

    
    
    //this piece of code adds the element to the UI window
	frame.add(typeofExercise);
	frame.add(typesExercises);
	frame.add(dateofExercise);
	frame.add(fDate);
	frame.add(fMonth);
	frame.add(fYear);
	frame.add(fromLabel);
	frame.add(fYearSlash);
	frame.add(fMonthSlash);
	frame.add(DurationLabel);
	frame.add(exerciseDuration);
	frame.add(intensityofExercise);
	frame.add(intensityType);
	frame.add(Save);
	frame.add(Back);  
	
//	frame.pack();
    
    //need this piece of code for the window to pop up
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400,400);
	frame.setLayout(null);
	frame.setVisible(true);
}
public void actionPerformed(ActionEvent e){   

	if(e.getSource() == Save) {
		try {
			int fromY, fromM, fromD;
			double durationbyHour;
			String intensityLevel;
			String exerciseActivity; 
			 fromY = Integer.parseInt(fYear.getText());
			 fromM = Integer.parseInt(fMonth.getText());
			 fromD = Integer.parseInt(fDate.getText());	 
			 durationbyHour = Double.parseDouble(exerciseDuration.getText());
			 intensityLevel = intensityType.getSelectedItem().toString();
			 exerciseActivity = typesExercises.getSelectedItem().toString();
			 
			 System.out.println("\nDATE: "+fromY+"/"+fromM+"/"+fromD+" duration: "+durationbyHour+" intensity: "
			 +intensityLevel+" exercise: "+exerciseActivity);
			 System.out.println("name: "+user.getFirstName()+"sex: "+user.getSex());
			 
			 String strDate;
			 
			 if(fYear.getText().length() == 4 && fMonth.getText().length() <= 2 && fDate.getText().length() <= 2) {
				 if(fromM <= 12 && fromD <=31 && durationbyHour < 24) {
					 System.out.println("Date is formatted properly");
				      
					 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
					 strDate = fDate.getText()+"-"+fMonth.getText()+"-"+fYear.getText();
					 Date date = new Date();
					 date = formatter.parse(strDate);
					 ExerciseUser Euser = new ExerciseUser(user, date, durationbyHour, exerciseActivity, intensityLevel);
					 Euser.insertExerciseData();
					 System.out.println(date);
					 
					 JOptionPane.showMessageDialog(this, "Your exercise log was recorded!");
					 dispose();
					 AccountHomePageUI a = new AccountHomePageUI(this.user);
					 frame.dispose();
					 a.setVisible(true); 
				 }
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Please retry", "alert", JOptionPane.ERROR_MESSAGE);
			 }	 
		}catch(Exception exc) {
			JOptionPane.showMessageDialog(null, "Please retry", "alert", JOptionPane.ERROR_MESSAGE);			
			exc.printStackTrace();
		}
	}
	else if(e.getSource() == Back) {
		AccountHomePageUI a = new AccountHomePageUI(this.user);
		frame.setVisible(false);
		frame.dispose();
		a.setVisible(true);	
	}
}

}
