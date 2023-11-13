

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExerciseLog implements ActionListener{
	

JFrame frame = new JFrame("Exercise Log");
JTextField fDate = new JTextField();
JTextField fMonth = new JTextField();
JTextField fYear = new JTextField();
JTextField tDate = new JTextField();
JTextField tMonth = new JTextField();
JTextField tYear = new JTextField();
JComboBox<String> typesExercises;
JComboBox<String> intensityType;
JButton Next = new JButton("Next");
JButton Print = new JButton("Print");

ArrayList<ExerciseData> list = new ArrayList<>();


public ExerciseLog(){
	
	//need this piece of code to set the size for UI elements 
	
	JLabel typeofExercise = new JLabel("What exercise do you want to log?");
	typeofExercise.setBounds(30, 10, 400, 100);
	
	Vector<String> exercises = new Vector<String>();
	exercises.add("Running");
	exercises.add("Jogging");
	exercises.add("Swimming");
	exercises.add("Walking");	
	
	typesExercises = new JComboBox<String>(exercises);
	typesExercises.setBounds(30, 80, 100, 20);
	typesExercises.addActionListener(this);
	
	JLabel durationofExercise = new JLabel("Give the time period you exercised (MM/DD/YY): ");
	durationofExercise.setBounds(30, 80, 400, 100);
	
	fDate.setBounds(30, 170, 20, 20);
	fMonth.setBounds(60, 170, 20, 20);
	fYear.setBounds(90, 170, 20, 20);
	JLabel fromLabel = new JLabel("From:");
	fromLabel.setBounds(30, 145, 40, 20);
	

	
	tDate.setBounds(135, 170, 20, 20);
	tMonth.setBounds(165, 170, 20, 20);
	tYear.setBounds(195, 170, 20, 20);
	JLabel toLabel = new JLabel("To:");
	toLabel.setBounds(135, 145, 40, 20);
	
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
	
	Next.setBounds(30, 300, 90, 20);
	Next.addActionListener(this);
    
	Print.setBounds(180, 300, 90, 20);
	Print.addActionListener(this);

    
    
    //this piece of code adds the element to the UI window
	frame.add(typeofExercise);
	frame.add(typesExercises);
	frame.add(durationofExercise);
	frame.add(fDate);
	frame.add(fMonth);
	frame.add(fYear);
	frame.add(fromLabel);
	frame.add(tDate);
	frame.add(tMonth);
	frame.add(tYear);
	frame.add(toLabel);
	frame.add(intensityofExercise);
	frame.add(intensityType);
	frame.add(Next);
	frame.add(Print);
	
    
    
    //need this piece of code for the window to pop up
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400,400);
	frame.setLayout(null);
	frame.setVisible(true);	
}

public void actionPerformed(ActionEvent e){   
	
	
	if(e.getSource() == Next) {
		String exercise = typesExercises.getSelectedItem().toString();
		String intensity = intensityType.getSelectedItem().toString();		
		int fromY, fromM, fromD, toY, toM, toD;
	try {
		 fromY = Integer.parseInt(fYear.getText());
		 fromM = Integer.parseInt(fMonth.getText());
		 fromD = Integer.parseInt(fDate.getText());
		
		 toY = Integer.parseInt(tYear.getText());
		 toM = Integer.parseInt(tMonth.getText());
		 toD = Integer.parseInt(tDate.getText());
	
		Date fromDate = new Date(fromY, fromM, fromD);
		Date toDate = new Date(toY, toM, toD);
		
		ExerciseData log = new ExerciseData(fromDate, toDate, intensity, exercise);
		list.add(log);
		
	}
	catch(Exception e1) {
		System.out.println("Please enter the dates with proper format");
	}

	}
	else if(e.getSource() == Print) {
		printLogs(list);
	}
}
public void printLogs(ArrayList<ExerciseData> list) {
	int i = 0;
	for( ExerciseData d: list) {
		System.out.println("log "+ (i++));
		System.out.println("exercise: "+d.getExercise()
							+"\nintensity: "+d.getIntensity()
							+"\nDate from: "+d.getFromdate().toString()
							+"\nDate to: "+d.getTodate().toString()+"\n\n");
	}
}
   




}
