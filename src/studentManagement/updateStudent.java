package studentManagement;

import common.Validator;
import javax.swing.JOptionPane;
import pojo.StudentData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to EditStudent this template
 */

/**
 *
 * @author DM
 */
public class updateStudent extends javax.swing.JFrame {

    StudentData studentToUpdate = null;
    /**
     * Creates new form update
     */
    public updateStudent(StudentData studentData) {
        studentToUpdate =  studentData;
        initComponents();
    }

    boolean isValidFName(String fname){
        if(fname.isEmpty()){
            JOptionPane.showMessageDialog(null, "First Name cannot be empty!");
            return  false;
        }
        if(!Validator.isAlphabet(fname)){
            JOptionPane.showMessageDialog(this,"First name should only contain alphabets.");
            return false;
        }

        if(fname.length() < 1 || fname.length() > 20){
            JOptionPane.showMessageDialog(this,"First name should have min 2 and max 20 characters.");
            return false;
        }
        return true;
    }
    boolean isValidLName(String lname){
        if(lname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Last Name cannot be empty!");
            return false;
        }

        if(!Validator.isAlphabet(lname)){
            JOptionPane.showMessageDialog(this,"Last name should only contain alphabets.");
            return false;
        }

        if(lname.length() < 1 || lname.length() > 20){
            JOptionPane.showMessageDialog(this,"Last name should have min 2 and max 20 characters.");
            return false;
        }
        return true;
    }

    boolean isValidDate(String dateToValidate){
        if(dateToValidate.isEmpty()){
            JOptionPane.showMessageDialog(null, "Date cannot be empty!");
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;
        
    }
    
    boolean isValidFatherName(String fathername){
        if(fathername.isEmpty()){
            JOptionPane.showMessageDialog(null, "Father's name cannot be empty!");
            return false;
        }

        if(!Validator.isAlphabet(fathername)){
            JOptionPane.showMessageDialog(this,"Father's name should only contain alphabets.");
            return false;
        }

        if(fathername.length() < 1 || fathername.length() > 30){
            JOptionPane.showMessageDialog(this,"Father's name should have min 2 and max 30 characters.");
            return false;
        }

        return true;
    }
    boolean isValidMotherName(String mname){
        if(mname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Mother's name cannot be empty!");
            return false;
        }

        if(!Validator.isAlphabet(mname)){
            JOptionPane.showMessageDialog(this,"Mother's name should only contain alphabets.");
            return false;
        }

        if(mname.length() < 1 || mname.length() > 30){
            JOptionPane.showMessageDialog(this,"Mother's name should have min 2 and max 30 characters.");
            return false;
        }
        return true;
    }
    boolean isValidTeleNum(String tnum){
        if(tnum.isEmpty()){
            JOptionPane.showMessageDialog(null, "Telephone number cannot be empty!");
            return false;
        }
        if(!Validator.isNumeric(tnum)){
            JOptionPane.showMessageDialog(this,"Telephone number should contain only numeric values.");
            return false;
        }

        if(!tnum.startsWith("0")){
            JOptionPane.showMessageDialog(this,"Telephone number should start with 0.");
            return false;
        }

        if(tnum.length() != 11){
            JOptionPane.showMessageDialog(this,"Please provide valid telephone number.");
            return false;
        }
        return true;
    }

    boolean isValidMobileNum(String mnum){
        if(mnum.isEmpty()){
            JOptionPane.showMessageDialog(null, "Mobile number cannot be empty!");
            return false;
        }

        if(!Validator.isNumeric(mnum)){
            JOptionPane.showMessageDialog(this,"Mobile number should contain only numeric values.");
            return false;
        }

        if(mnum.length() != 10){
            JOptionPane.showMessageDialog(this,"Please provide valid Mobile number.");
            return false;
        }

        return true;
    }
    boolean isValidAddress(String address){
        if(address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Address cannot be empty!");
            return false;
        }
        if(!Validator.isAlphaNumeric(address)){
            JOptionPane.showMessageDialog(this,"Address should contain only alphabets and numeric values.");
            return false;
        }

        if(address.length() < 10 || address.length() > 250){
            JOptionPane.showMessageDialog(this,"Address should have min 10 and max 250 characters.");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        uaddress = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        father = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        mother = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        htele = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mnum = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uaddress.setColumns(20);
        uaddress.setRows(5);
        jScrollPane1.setViewportView(uaddress);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("First_Name");


        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Last_Name ");

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        firstname.setText(studentToUpdate.getFirstName());

        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        firstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstnameKeyPressed(evt);
            }
        });

        lastname.setText(studentToUpdate.getLastName());
        lastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastnameKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Date Of Birth");
        date.setText(studentToUpdate.getDateOfBirth());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Gender");
        gender.setSelectedItem(studentToUpdate.getGender());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Father's Name");

        father.setText(studentToUpdate.getFatherName());
        father.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherActionPerformed(evt);
            }
        });
        father.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fatherKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Mother's Name");
        mother.setText(studentToUpdate.getMotherName());

        mother.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                motherKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("Home Telephone");

        htele.setText(studentToUpdate.getHomeTelephone());
        htele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hteleActionPerformed(evt);
            }
        });
        htele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hteleKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("Mobile Number");
        mnum.setText(studentToUpdate.getMobileNumber());
        mnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnumKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setText("Address");
        uaddress.setText(studentToUpdate.getAddress());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setText("Class");


        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class", "11A", "11B", "12A", "12B" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.setSelectedItem(studentToUpdate.getClassStandard());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Update data");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(htele, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mnum, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(father, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(mother, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(firstname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(father, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(htele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void firstnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameKeyPressed
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        
        if(!(c >= '0' && c<= '9')){
                firstname.setEditable(true);
        }else{
             firstname.setEditable(false);
             JOptionPane.showMessageDialog(null, "First name should only contain alphabets");
        }

    }//GEN-LAST:event_firstnameKeyPressed

    private void lastnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameKeyPressed
        // TODO add your handling code here:
       Character c = evt.getKeyChar();
        
        if(!(c >= '0' && c<= '9')){
                lastname.setEditable(true);
        }else{
             lastname.setEditable(false);
             JOptionPane.showMessageDialog(null, "Last name should only contain alphabets");
        }
    }//GEN-LAST:event_lastnameKeyPressed

    private void fatherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatherActionPerformed

    private void fatherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherKeyPressed
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        
        if(!(c >= '0' && c<= '9')){
                father.setEditable(true);
        }else{
             father.setEditable(false);
             JOptionPane.showMessageDialog(null, "Father's name should only contain alphabets");
        }
    }//GEN-LAST:event_fatherKeyPressed

    private void motherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motherKeyPressed
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        
        if(!(c >= '0' && c<= '9')){
                mother.setEditable(true);
        }else{
             mother.setEditable(false);
             JOptionPane.showMessageDialog(null, "Mother's name should only contain alphabets");
        }
    }//GEN-LAST:event_motherKeyPressed

    private void hteleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hteleActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_hteleActionPerformed

    private void hteleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hteleKeyPressed
        // TODO add your handling code here:
         Character c = evt.getKeyChar();

        if(Character.isLetter(c)){
            htele.setEditable(false);
            JOptionPane.showMessageDialog(this,"Telephone number should contain only numeric values.");
        }else{
            htele.setEditable(true);           
        }
    }//GEN-LAST:event_hteleKeyPressed

    private void mnumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnumKeyPressed
        // TODO add your handling code here:
        Character c = evt.getKeyChar();

        if(Character.isLetter(c)){
            mnum.setEditable(false);
            JOptionPane.showMessageDialog(this,"Mobile number should contain only numeric values.");
        }else{
            mnum.setEditable(true);

        }
    }//GEN-LAST:event_mnumKeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        editStudent e1 = new editStudent();
        e1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void resetFields(){
        mnum.setText("");
        htele.setText("");
        father.setText("");
        mother.setText("");
        firstname.setText("");
        lastname.setText("");
        uaddress.setText("");
        date.setText("");
        gender.setSelectedItem("Select Gender");
        jComboBox1.setSelectedIndex(0);


    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String fName = firstname.getText().trim();
        if(!isValidFName(fName)){
            return;
        }

        String lName = lastname.getText().trim();
        if(!isValidLName(lName)){
            return;
        }

        String dob = date.getText().trim();
        if(!isValidDate(dob)){
            return;
        }

        String selectedGender = gender.getSelectedItem().toString();
        if("Select Gender".equals(selectedGender)){
                JOptionPane.showMessageDialog(null, "Please select gender!");
                return;
        }

        String fatherName = father.getText().trim();
        if(!isValidFatherName(fatherName)){
            return;
        }

        String montherName = mother.getText().trim();
        if(!isValidMotherName(montherName)){
            return;
        }

        String homeTel = htele.getText().trim();
        if(!isValidTeleNum(homeTel)){
            return;
        }

        String mobile = mnum.getText().trim();
        if(!isValidMobileNum(mobile)){
            return; 
        }

        String addr = uaddress.getText().trim();
        if(!isValidAddress(addr)){
            return;
        }

        String classStd = jComboBox1.getSelectedItem().toString();
        if("Select Class".equals(classStd)) {
            JOptionPane.showMessageDialog(null, "Please select class!");
            return;
        }

        StudentData updatedStudent = new StudentData();
        updatedStudent.setRollNum(studentToUpdate.getRollNum());
        updatedStudent.setFirstName(fName);
        updatedStudent.setLastName(lName);
        updatedStudent.setDateOfBirth(dob);
        updatedStudent.setGender(selectedGender);
        updatedStudent.setFatherName(fatherName);
        updatedStudent.setMotherName(montherName);
        updatedStudent.setHomeTelephone(homeTel);
        updatedStudent.setMobileNumber(mobile);
        updatedStudent.setAddress(addr);
        updatedStudent.setClassStandard(classStd);

        if(StudentData.update(updatedStudent)){
            JOptionPane.showMessageDialog(this,"Successfully updated student.");
            dispose();
            Tasks tk = new Tasks();
            tk.setVisible(true);
            this.dispose();
        }else {
            JOptionPane.showMessageDialog(this,"Failed to add student, please try again later.");
            resetFields();
            return;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateStudent(new StudentData()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JTextField father;
    private javax.swing.JTextField firstname;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JTextField htele;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField mnum;
    private javax.swing.JTextField mother;
    private javax.swing.JTextArea uaddress;
    // End of variables declaration//GEN-END:variables
}
