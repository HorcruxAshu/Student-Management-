package pojo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    private List<StudentData> studentList = new ArrayList<>();
    private  String [] studentColumns = new String[] {"Roll No", "FirstName","LastName", "Gender","DOB", "Address","Father's Name", "Mother's Name","Home Telephone","MobileNo","Class Standard"};

    public void setStudentList(List<StudentData> studentList) {
        this.studentList = studentList;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return studentColumns[column];
    }

    @Override
    public int getRowCount() {
        return studentList.size();
    }

    @Override
    public int getColumnCount() {
        return studentColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return studentList.get(rowIndex).getRollNum();
            case 1:
                return studentList.get(rowIndex).getFirstName();
            case 2:
                return studentList.get(rowIndex).getLastName();
            case 3:
                return studentList.get(rowIndex).getGender();
            case 4:
                return studentList.get(rowIndex).getDateOfBirth();
            case 5:
                return studentList.get(rowIndex).getAddress();
            case 6:
                return studentList.get(rowIndex).getFatherName();
            case 7:
                return studentList.get(rowIndex).getMotherName();
            case 8:
                return studentList.get(rowIndex).getHomeTelephone();
            case 9:
                return studentList.get(rowIndex).getMobileNumber();
            case 10:
                return studentList.get(rowIndex).getClassStandard();
            default:
                return null;
        }
    }
}

