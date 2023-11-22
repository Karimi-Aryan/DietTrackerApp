
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author aryankarimi
 */
public class FatLossCalcUI extends javax.swing.JFrame {

    private int avgCalsBurned =2;
    private int avgCalsConsumed =3;
    private User user;
    private FatLossCalculator newCalc;

    /**
     * Creates new form FatLossCalcUI
     */
    public FatLossCalcUI(User user) {
        this.user = user;
        this.newCalc = new FatLossCalculator();
        this.avgCalsBurned = newCalc.getBiWeeklyCalsBurned_Avg(user.getAccID());
        this.avgCalsConsumed = newCalc.getDailyColoric_Avg(user.getAccID());
        initComponents();
    }
    public FatLossCalcUI() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        editYear = new javax.swing.JTextField();
        editMonth = new javax.swing.JTextField();
        editDay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        OKbtn = new javax.swing.JButton();
        FatLossResult = new javax.swing.JLabel();
        BackBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("End Date (yyyy/mm/dd)");

        editYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editYearActionPerformed(evt);
            }
        });
        editYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editYearKeyTyped(evt);
            }
        });

        editMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMonthActionPerformed(evt);
            }
        });
        editMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editMonthKeyTyped(evt);
            }
        });

        editDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDayActionPerformed(evt);
            }
        });
        editDay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editDayKeyTyped(evt);
            }
        });

        jLabel6.setText("/");

        jLabel7.setText("/");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("based on current average caloric intake and exercise");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setText("Enter target end date to see how much fat you will lose");
        jLabel2.setOpaque(true);

        jLabel3.setText("Avg caloric intake: ");

        jLabel4.setText("Avg daily cals burned: ");

        jLabel8.setText("Fat Lost: ");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 2, 10)); // NOI18N
        jLabel9.setText("* Avg is based on last 14 days");

        jLabel10.setText(Integer.toString(this.avgCalsConsumed));

        jLabel11.setText(Integer.toString(this.avgCalsBurned));

        OKbtn.setText("OK");
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbtnActionPerformed(evt);
            }
        });

        FatLossResult.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N

        BackBTN.setText("Back");
        BackBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBTNMouseClicked(evt);
            }
        });
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editYear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editDay, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FatLossResult, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(106, 106, 106))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(OKbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BackBTN)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbtn)
                    .addComponent(BackBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FatLossResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editDayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editDayKeyTyped
        digitDoubleInputErrorHandling(evt);

        if(editDay.getText().length() == 2){
            evt.consume();
        }
    }//GEN-LAST:event_editDayKeyTyped

    private void editDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editDayActionPerformed

    private void editMonthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editMonthKeyTyped
        digitDoubleInputErrorHandling(evt);

        if(editMonth.getText().length() == 2){
            evt.consume();
        }
    }//GEN-LAST:event_editMonthKeyTyped

    private void editMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMonthActionPerformed

        
    }//GEN-LAST:event_editMonthActionPerformed

    private void editYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editYearKeyTyped
        digitDoubleInputErrorHandling(evt);

        if(editYear.getText().length() == 4){
            evt.consume();
    }//GEN-LAST:event_editYearKeyTyped
    }
    
    private void editYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editYearActionPerformed

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        
       ErrorHandling_AccountInfo dateCheck = new ErrorHandling_AccountInfo();
       if(dateCheck.EmptyCheck_Date(editYear.getText(), editMonth.getText(), editDay.getText()) == 1) return;
       String [] dateSplit = dateCheck.DateCleanUp(editYear.getText(),editMonth.getText(),editDay.getText());
       String date = dateSplit[0] +"-"+ dateSplit[1]+"-"+ dateSplit[2];
       if(dateCheck.ErrorCheck_Date(date) == 1) return;
       
       LocalDate userDate = LocalDate.parse(date);
        LocalDate currentDate = LocalDate.now();
        

        long daysBetween = ChronoUnit.DAYS.between(currentDate, userDate);
        
        if (daysBetween <0){
           JOptionPane.showMessageDialog(null, "Must pick a future date"
                    , "Invalid Date: ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       
        System.out.println(date);
        System.out.println(daysBetween);
        System.out.println(this.avgCalsBurned);
        System.out.println(this.avgCalsConsumed);
        
        
        
       
        //getting BMR and cals gained and lost here
        
        this.newCalc.getBmr(this.user.getHeight(), this.user.getWeight(), this.user.getAge(), this.user.getSex(), this.user.getUnits());
        int calsAfterBMR = this.newCalc.getCalsLost(this.avgCalsBurned, this.avgCalsConsumed);
        
        double futureCals = calsAfterBMR * daysBetween;
        double fatGainedorLoss = (double) Math.round((futureCals / 7700) * 100) / 100;  //7700cal per kg of fat 
        String unitsUsed = " kg";
        
        //check for units
        
        if (this.user.getUnits() == "Imperial"){
            fatGainedorLoss = (double) Math.round((fatGainedorLoss/ 2.20462) * 100) / 100;
            unitsUsed = " pounds";
            
            if(fatGainedorLoss == 1){
                unitsUsed = " pound";
            }
        }
        
        //send message to user regarding the outcome
        
        
        if(calsAfterBMR > 0){
            //fat will be gained 
            
            JOptionPane.showMessageDialog(this, "Fat Loss has been calculated and you will gain "+fatGainedorLoss+unitsUsed);
           FatLossResult.setText(Double.toString(fatGainedorLoss)+ unitsUsed);
            
        } else if (calsAfterBMR < 0){
            //fat will be lost
            fatGainedorLoss = fatGainedorLoss*-1;
            JOptionPane.showMessageDialog(this, "Fat Loss has been calculated and you will lose "+fatGainedorLoss+unitsUsed);
            FatLossResult.setText(Double.toString(fatGainedorLoss) + unitsUsed);
        }
          
        return;
            
        
        
    }//GEN-LAST:event_OKbtnActionPerformed

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBTNActionPerformed

    private void BackBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseClicked
        AccountHomePageUI home = new AccountHomePageUI();
        home.HomePageUI(this.user);
        dispose();
        
        
    }//GEN-LAST:event_BackBTNMouseClicked

private void digitDoubleInputErrorHandling(java.awt.event.KeyEvent evt){
         char typed = evt.getKeyChar();
        
        if(!Character.isDigit(typed)){
            if(typed == '.'){
                return;
            }
            evt.consume();
        }
    }
    
    private void alphaCharInputErrorHandling(java.awt.event.KeyEvent evt){
           char typed = evt.getKeyChar();
        
        if(!Character.isAlphabetic(typed)){
            if(typed == '-'){
                return;
            }
            evt.consume();
        }
    }

    
       
    
    /**
     * @param args the command line arguments
     */
    public static void FatLossCalc(User user) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FatLossCalcUI(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JLabel FatLossResult;
    private javax.swing.JButton OKbtn;
    private javax.swing.JTextField editDay;
    private javax.swing.JTextField editMonth;
    private javax.swing.JTextField editYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}