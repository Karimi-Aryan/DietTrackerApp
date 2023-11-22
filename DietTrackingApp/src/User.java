/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class User {

    protected  String firstName;
    protected  String lastName;
    protected  int age;
    protected  double weight;
    protected double height;
    protected String sex;
    protected String units;
    protected int accID;
    protected String dob;
    
    public User(int accountNum,String fName, String lName, int age, double weight, double height, String sex, String units){
        
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.units = units;
        this.accID = accountNum;
        
        
    }
     public User(int accountNum,String fName, String lName, int age, double weight, double height, String sex){
        
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.accID = accountNum;
        
        
    }
     
     public User(int accountNum,String fName, String lName, int age, double weight, double height, String sex, String units, String dob){
        
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.units = units;
        this.accID = accountNum;
        this.dob = dob;
        
        
    }
    
    public User(){
        
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * @return the accID
     */
    public int getAccID() {
        return accID;
    }

    /**
     * @param accID the accID to set
     */
    public void setAccID(int accID) {
        this.accID = accID;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }
    
}
