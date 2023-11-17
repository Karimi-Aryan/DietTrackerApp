
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ /**
 *
 * @author aryankarimi
 */
public interface AccountInterface {

    void AddAccount();

    void UpdateAccount();
    
    String [] GetAllAccounts();
    
    User getSelectedAccount(int i);
    
    void UpdateAge();
    
    
    
}
