/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
interface ErrorInterface {
    
    int ErrorCheck_AccountInfo();
    int ErrorCheck_Date(String dob);
    String [] DateCleanUp(String year, String month, String day);
    
    int EmptyCheck_Date(String year, String month, String day);
    int EmptyCheck_Name(String fname, String lname);
    int EmptyCheck_Units(String weight, String height);
}
