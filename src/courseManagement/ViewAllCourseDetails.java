package courseManagement;

import pojo.CourseData;
import pojo.CourseTableModel;
import pojo.StudentData;
import pojo.StudentTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAllCourseDetails extends JFrame implements ActionListener {

    CourseTableModel tableModel = new CourseTableModel();
    public ViewAllCourseDetails(){
        //setLayout(null);
        setVisible(true);
        setSize(1000,700);
        setTitle("Course Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<CourseData> rows = CourseData.getAllCourseDetails();
        JTable table =new JTable();
        table.setBounds(50,100,1000,400);
        tableModel.setCourseList(rows);
        table.setModel(tableModel);
        add(new JScrollPane(table));

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

