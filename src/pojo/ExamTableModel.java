package pojo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ExamTableModel extends AbstractTableModel {

    private List<ExamData> examDetailsList = new ArrayList<>();
    private  String [] examDetailsColumns = new String[] {"Student RollNum", "Class", "Test Name", "Sub1 Name","Sub1 Marks",
            "Sub2 Name","Sub2 Marks", "Sub3 Name","Sub3 Marks", "Sub4 Name","Sub4 Marks", "Sub5 Name","Sub5 Marks","Sub6 Name","Sub6 Marks"};

    public void setExamDetailsList(List<ExamData> examDetailsList) {
        this.examDetailsList = examDetailsList;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return examDetailsColumns[column];
    }

    @Override
    public int getRowCount() {
        return examDetailsList.size();
    }

    @Override
    public int getColumnCount() {
        return examDetailsColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return examDetailsList.get(rowIndex).getStudRollNum();
            case 1:
                return examDetailsList.get(rowIndex).getClassName();
            case 2:
                return examDetailsList.get(rowIndex).getTestName();
            case 3:
                return examDetailsList.get(rowIndex).getSub1Name();
            case 4:
                return examDetailsList.get(rowIndex).getSub1Score();
            case 5:
                return examDetailsList.get(rowIndex).getSub2Name();
            case 6:
                return examDetailsList.get(rowIndex).getSub2Score();
            case 7:
                return examDetailsList.get(rowIndex).getSub3Name();
            case 8:
                return examDetailsList.get(rowIndex).getSub3Score();
            case 9:
                return examDetailsList.get(rowIndex).getSub4Name();
            case 10:
                return examDetailsList.get(rowIndex).getSub4Score();
            case 11:
                return examDetailsList.get(rowIndex).getSub5Name();
            case 12:
                return examDetailsList.get(rowIndex).getSub5Score();
            case 13:
                return examDetailsList.get(rowIndex).getSub6Name();
            case 14:
                return examDetailsList.get(rowIndex).getSub6Score();
            default:
                return null;
        }
    }
}

