package pojo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CourseTableModel extends AbstractTableModel {

    private List<CourseData> courseList = new ArrayList<>();
    private  String [] courseColumns = new String[] {"Class Name", "Subject 1","Subject 2", "Subject 3","Subject 4", "Subject 5","Subject 6"};

    public void setCourseList(List<CourseData> courseList) {
        this.courseList = courseList;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return courseColumns[column];
    }

    @Override
    public int getRowCount() {
        return courseList.size();
    }

    @Override
    public int getColumnCount() {
        return courseColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return courseList.get(rowIndex).getClassName();
            case 1:
                return courseList.get(rowIndex).getSub1();
            case 2:
                return courseList.get(rowIndex).getSub2();
            case 3:
                return courseList.get(rowIndex).getSub3();
            case 4:
                return courseList.get(rowIndex).getSub4();
            case 5:
                return courseList.get(rowIndex).getSub5();
            case 6:
                return courseList.get(rowIndex).getSub6();
            default:
                return null;
        }
    }
}

