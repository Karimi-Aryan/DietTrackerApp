import java.util.Date;

public class ExerciseData {
	private Date from;
	private Date to;
	private String intensity;
	private String exercise;
	
	
	
	public ExerciseData(Date f, Date t, String i, String e) {
		this.exercise = e;
		this.intensity = i;
		this.from = f;
		this.to = t;		
	}
	public String getIntensity() {
		return intensity;
	}
	public String getExercise() {
		return exercise;
	}
	public Date getFromdate() {
		return from;
	}
	public Date getTodate() {
		return to;
	}
	
}
