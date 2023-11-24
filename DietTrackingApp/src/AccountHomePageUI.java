/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author aryankarimi
 */
public class AccountHomePageUI extends javax.swing.JFrame {
User user = new User();
    /**
     * Creates new form AccountHomePage
     */
    public AccountHomePageUI() {
        initComponents();
    }
    
     public AccountHomePageUI(User localUser) {
         initComponents();
         this.user = localUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AccountInfoUpdateBTN = new javax.swing.JButton();
        settingsChangeBTN = new javax.swing.JButton();
        mealLoggingBTN = new javax.swing.JButton();
        exerciseLoggingBTN = new javax.swing.JButton();
        calorieIntakeGraphBTN = new javax.swing.JButton();
        bmrCalcBTN = new javax.swing.JButton();
        FatLossBTN = new javax.swing.JButton();
        LogOutBTN = new javax.swing.JButton();
        visualizeAvgPlateBTN = new javax.swing.JButton();	
        nutrientIntakeBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AccountInfoUpdateBTN.setText("Account Info");
        AccountInfoUpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountInfoUpdateBTNActionPerformed(evt);
            }
        });

        settingsChangeBTN.setText("Settings");
        settingsChangeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsChangeBTNActionPerformed(evt);
            }
        });

        mealLoggingBTN.setText("Meal Logging");
        mealLoggingBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mealLoggingBTNActionPerformed(evt);
            }
        });
        
        nutrientIntakeBTN.setText("Nutrient Intake");
        nutrientIntakeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutrientIntakeBTNActionPerformed(evt);
            }
        });


        exerciseLoggingBTN.setText("Exercise Logging");
        exerciseLoggingBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciseLoggingBTNActionPerformed(evt);
            }
        });

        calorieIntakeGraphBTN.setText("Calorie Intake Graph");
        calorieIntakeGraphBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calorieIntakeGraphBTNActionPerformed(evt);
            }
        });

        bmrCalcBTN.setText("BMR calculator");
        bmrCalcBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmrCalcBTNActionPerformed(evt);
            }
        });

        FatLossBTN.setText("Fat Loss Calculator");
        FatLossBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FatLossBTNActionPerformed(evt);
            }
        });
        
        visualizeAvgPlateBTN.setText("Visualize Average Plate");	
        visualizeAvgPlateBTN.addActionListener(new java.awt.event.ActionListener() {	
            public void actionPerformed(java.awt.event.ActionEvent evt) {	
            	visualizeAvgPlateBTNActionPerformed(evt);	
            	
            }
        });
        
        LogOutBTN.setText("Log Out");
        LogOutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogOutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FatLossBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(calorieIntakeGraphBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exerciseLoggingBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mealLoggingBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nutrientIntakeBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(settingsChangeBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AccountInfoUpdateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(visualizeAvgPlateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)	
                        .addComponent(bmrCalcBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(AccountInfoUpdateBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsChangeBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mealLoggingBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exerciseLoggingBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nutrientIntakeBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calorieIntakeGraphBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bmrCalcBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FatLossBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualizeAvgPlateBTN)	
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)	
                .addComponent(LogOutBTN)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void settingsChangeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsChangeBTNActionPerformed

        SettingsUpdateUI settings = new SettingsUpdateUI();
        settings.SettingsUpdate(this.user);
        dispose();

    }//GEN-LAST:event_settingsChangeBTNActionPerformed

    private void bmrCalcBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmrCalcBTNActionPerformed

        BMRcalculationUI bmr = new BMRcalculationUI(this.user);
        bmr.BMRCalc(this.user);  
        dispose();
        
        
    }//GEN-LAST:event_bmrCalcBTNActionPerformed

    private void AccountInfoUpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountInfoUpdateBTNActionPerformed

        AccountInfoUpdateUI infoUpdate = new AccountInfoUpdateUI(this.user);
        infoUpdate.InfoUpdate(this.user);
        dispose();




    }//GEN-LAST:event_AccountInfoUpdateBTNActionPerformed

    private void mealLoggingBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mealLoggingBTNActionPerformed
        MealLoggerUI mealLoggerUI = new MealLoggerUI(this.user);

    }//GEN-LAST:event_mealLoggingBTNActionPerformed

    private void nutrientIntakeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutrientIntakeBTNActionPerformed
        DietAnalyzerUI dietAnalyzerUI = new DietAnalyzerUI(this.user.getAccID());
    }//GEN-LAST:event_nutrientIntakeBTNActionPerformed

    private void visualizeAvgPlateBTNActionPerformed(java.awt.event.ActionEvent evt) {
     DietVizualizationUI dietVizualizationUI = new DietVizualizationUI(this.user.getAccID());
    }
    
    private void exerciseLoggingBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciseLoggingBTNActionPerformed
    	ExerciseLog exerciseLog = new ExerciseLog(this.user);
    	exerciseLog.ExerciseLogUI();
    	dispose();
    }//GEN-LAST:event_exerciseLoggingBTNActionPerformed

    private void calorieIntakeGraphBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calorieIntakeGraphBTNActionPerformed
        
    }//GEN-LAST:event_calorieIntakeGraphBTNActionPerformed

    private void FatLossBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FatLossBTNActionPerformed
    	FatLossCalcUI fatLossCalc = new FatLossCalcUI();
    	fatLossCalc.FatLossCalc(this.user); 
    	dispose();
    }//GEN-LAST:event_FatLossBTNActionPerformed

    private void LogOutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBTNActionPerformed
       String[] args = {""};
       StartScreenUI.main(args);
       dispose();
    }//GEN-LAST:event_LogOutBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public void HomePageUI(User user) {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountHomePageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountHomePageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountHomePageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountHomePageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountHomePageUI(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccountInfoUpdateBTN;
    private javax.swing.JButton FatLossBTN;
    private javax.swing.JButton LogOutBTN;
    private javax.swing.JButton bmrCalcBTN;
    private javax.swing.JButton calorieIntakeGraphBTN;
    private javax.swing.JButton exerciseLoggingBTN;
    private javax.swing.JButton mealLoggingBTN;
    private javax.swing.JButton settingsChangeBTN;
    private javax.swing.JButton visualizeAvgPlateBTN;	
    private javax.swing.JButton nutrientIntakeBTN;

    // End of variables declaration//GEN-END:variables
}
