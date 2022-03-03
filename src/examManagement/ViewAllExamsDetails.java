package examManagement;

import pojo.CourseData;
import pojo.CourseTableModel;
import pojo.ExamData;
import pojo.ExamTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAllExamsDetails extends JFrame implements ActionListener {

    ExamTableModel tableModel = new ExamTableModel();
    public ViewAllExamsDetails(List<ExamData> rows){
        //setLayout(null);
        setVisible(true);
        setSize(1000,700);
        setTitle("Exams Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //List<ExamData> rows = ExamData.getAllExamsDetails();
        JTable table =new JTable();
        table.setBounds(50,100,1000,400);
        tableModel.setExamDetailsList(rows);
        table.setModel(tableModel);
        add(new JScrollPane(table));

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

