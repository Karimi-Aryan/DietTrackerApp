/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template

 */
import java.time.LocalDate;  
import java.time.Period;  
import java.util.Scanner; 
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author aryankarimi
 */
public class AccountInfoUpdateUI extends javax.swing.JFrame {

    private User user;

    /**
     * Creates new form AccountSettings
     */
    public AccountInfoUpdateUI() {
        initComponents();
    }
    
    public AccountInfoUpdateUI(User localUser) {
        
        this.user = localUser; 
        initComponents();
        editFirstName.setText(this.user.getFirstName());
        editLastName.setText(this.user.getLastName());
        editHeight.setText(Double.toString((this.user.getHeight())));
        editWeight.setText(Double.toString(this.user.getWeight()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editHeight = new javax.swing.JTextField();
        editWeight = new javax.swing.JTextField();
        editDay = new javax.swing.JTextField();
        editMonth = new javax.swing.JTextField();
        editYear = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editSex = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        editLastName = new javax.swing.JTextField();
        editFirstName = new javax.swing.JTextField();
        heightUnitLabel = new javax.swing.JLabel();
        WeightUnitLabel = new javax.swing.JLabel();

        jCheckBox2.setText("jCheckBox2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Please Fill In the Following Information");

        jLabel2.setText("Sex");

        jLabel3.setText("Height");

        jLabel4.setText("Weight");

        jLabel5.setText("Date of birth (yyyy/mm/dd)");

        editHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHeightActionPerformed(evt);
            }
        });

        editWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editWeightActionPerformed(evt);
            }
        });

        editDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDayActionPerformed(evt);
            }
        });

        editMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMonthActionPerformed(evt);
            }
        });

        editYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editYearActionPerformed(evt);
            }
        });

        jLabel6.setText("/");

        jLabel7.setText("/");

        if (this.user.getSex().equals("Male")){
            editSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        }
        else {
            editSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));

        }
        editSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSexActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Last Name");

        jLabel9.setText("First Name");

        editLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLastNameActionPerformed(evt);
            }
        });

        editFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFirstNameActionPerformed(evt);
            }
        });

        System.out.println(this.user.getUnits());
        if (this.user.getUnits().equals("Metric")){
            heightUnitLabel.setText("cm");
        } else if (this.user.getUnits().equals("Imperial")){
            heightUnitLabel.setText("inches");
        }

        if (this.user.getUnits().equals("Metric")){
            WeightUnitLabel.setText("kg");
        }else if (this.user.getUnits().equals("Imperial")){
            WeightUnitLabel.setText("pounds");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(saveBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(134, 134, 134))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(editWeight, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editHeight, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editSex, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editFirstName, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heightUnitLabel)
                                    .addComponent(WeightUnitLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editYear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editDay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(editLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(editSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightUnitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(editWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WeightUnitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(editMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editHeightActionPerformed

    private void editWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editWeightActionPerformed

    private void editDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editDayActionPerformed

    private void editMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMonthActionPerformed

    private void editYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editYearActionPerformed

    private void editSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editSexActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        
        //getting all data inserted from user 
        
        String firstName = editFirstName.getText();
        String lastName = editLastName.getText();
        String sex = editSex.getSelectedItem().toString();
        double height = Double.parseDouble(editHeight.getText());
        double weight = Double.parseDouble(editWeight.getText());
        int accID = this.user.getAccID();
        
        LocalDate dob = LocalDate.parse(editYear.getText()+"-"+editMonth.getText()+"-"+editDay.getText());
        LocalDate currentDate = LocalDate.now();
        
        Period period = Period.between(dob,currentDate);
        
        int age = period.getYears();
        
        AccountSetUp updatedAccount = new AccountSetUp(accID,firstName, lastName, age, weight, height, sex);
        updatedAccount.UpdateAccount();

        
        
        //sending info to database
        
         /* try{
             
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountInfo","root","Uncharted4ever");
           
            PreparedStatement update = connect.prepareStatement("UPDATE INFO SET userFirstName = ?, userLastName = ?, userAge = ?, userWeight = ?, userHeight = ?, userSex = ? WHERE AccountID = ?;");
           
           
           update.setString(1,firstName);
           update.setString(2,lastName);
           update.setInt(3,age);
           update.setDouble(4,weight);
           update.setDouble(5,height);
           update.setString(6,sex);
           update.setInt(7,accID);
           

           update.executeUpdate();
           
           System.out.println("We did it!");
           
            
            
            
           //my SQL statement 
            
           
           
           //Executing SQL query "(userFirstName, userLastName,userAge,userWeight,userHeight,userSex)   '"+sex+", '"+height+", '"+weight+", '"+age+"')";
           
           
           
           
         }catch (Exception e){
             System.out.println("We didnt do it....");
         }
       
        */
        
        dispose();
        
        JOptionPane.showMessageDialog(this, "Your Profile has been updated!");
        
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(sex);
        System.out.println(height);
        System.out.println(weight);
        System.out.println(age);
        
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void editLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editLastNameActionPerformed

    private void editFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFirstNameActionPerformed
  

    /**
     * @param args the command line arguments
     */
    public void InfoUpdate(User user) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountInfoUpdateUI(user).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel WeightUnitLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField editDay;
    private javax.swing.JTextField editFirstName;
    private javax.swing.JTextField editHeight;
    private javax.swing.JTextField editLastName;
    private javax.swing.JTextField editMonth;
    private javax.swing.JComboBox<String> editSex;
    private javax.swing.JTextField editWeight;
    private javax.swing.JTextField editYear;
    private javax.swing.JLabel heightUnitLabel;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
