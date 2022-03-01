package studentManagementSystem;

import pojo.StudentData;
import pojo.StudentTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAllStudents extends JFrame implements ActionListener {

    StudentTableModel tableModel = new StudentTableModel();
    public ViewAllStudents(){
        //setLayout(null);
        setVisible(true);
        setSize(1000,700);
        setTitle("Student Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<StudentData> rows = StudentData.getAllStudents();
        JTable table =new JTable();
        table.setBounds(50,100,1000,400);
        tableModel.setStudentList(rows);
        table.setModel(tableModel);
        add(new JScrollPane(table));

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

