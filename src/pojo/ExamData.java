package pojo;

import common.Constants;
import common.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExamData {
    String testName;
    String className;
    String studRollNum;
    String sub1Name;
    String sub1Score;
    String sub2Name;
    String sub2Score;
    String sub3Name;
    String sub3Score;
    String sub4Name;
    String sub4Score;
    String sub5Name;
    String sub5Score;
    String sub6Name;
    String sub6Score;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudRollNum() {
        return studRollNum;
    }

    public void setStudRollNum(String studRollNum) {
        this.studRollNum = studRollNum;
    }

    public String getSub1Name() {
        return sub1Name;
    }

    public void setSub1Name(String sub1Name) {
        this.sub1Name = sub1Name;
    }

    public String getSub1Score() {
        return sub1Score;
    }

    public void setSub1Score(String sub1Score) {
        this.sub1Score = sub1Score;
    }

    public String getSub2Name() {
        return sub2Name;
    }

    public void setSub2Name(String sub2Name) {
        this.sub2Name = sub2Name;
    }

    public String getSub2Score() {
        return sub2Score;
    }

    public void setSub2Score(String sub2Score) {
        this.sub2Score = sub2Score;
    }

    public String getSub3Name() {
        return sub3Name;
    }

    public void setSub3Name(String sub3Name) {
        this.sub3Name = sub3Name;
    }

    public String getSub3Score() {
        return sub3Score;
    }

    public void setSub3Score(String sub3Score) {
        this.sub3Score = sub3Score;
    }

    public String getSub4Name() {
        return sub4Name;
    }

    public void setSub4Name(String sub4Name) {
        this.sub4Name = sub4Name;
    }

    public String getSub4Score() {
        return sub4Score;
    }

    public void setSub4Score(String sub4Score) {
        this.sub4Score = sub4Score;
    }

    public String getSub5Name() {
        return sub5Name;
    }

    public void setSub5Name(String sub5Name) {
        this.sub5Name = sub5Name;
    }

    public String getSub5Score() {
        return sub5Score;
    }

    public void setSub5Score(String sub5Score) {
        this.sub5Score = sub5Score;
    }

    public String getSub6Name() {
        return sub6Name;
    }

    public void setSub6Name(String sub6Name) {
        this.sub6Name = sub6Name;
    }

    public String getSub6Score() {
        return sub6Score;
    }

    public void setSub6Score(String sub6Score) {
        this.sub6Score = sub6Score;
    }

    public static List<ExamData> getAllExamsDetails(){
        List<ExamData> allExamsDetails = new ArrayList<>();
        try {
            List<String> lines = FileOperations.readData(Constants.EXAM_DATA);
            for(String line : lines) {
                ExamData data = mapLinesToExamsModel(line);
                allExamsDetails.add(data);
            }
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while reading exams data - " + ex);
        }
        return allExamsDetails;
    }

    public static ExamData getExamDetailsByRollNo(String rollno){
        return getAllExamsDetails().stream()
                .filter(x ->x.getStudRollNum().equalsIgnoreCase(rollno))
                .findFirst()
                .orElse(null);
    }

    public static ExamData getExamDetailsByRollNoAndTestName(String rollno, String testName){
        return getAllExamsDetails().stream()
                .filter(x ->x.getStudRollNum().equalsIgnoreCase(rollno) && x.getTestName().equalsIgnoreCase(testName))
                .findFirst()
                .orElse(null);
    }

    public static boolean add(ExamData examDatails){
        String examData = mapExamsModelToString(examDatails);

        if(!FileOperations.saveData(Constants.EXAM_DATA, examData)){
            return false;
        }
        return true;
    }

    public static boolean update(ExamData examDatailsToUpdate) {
        try {
            List<String> lines = FileOperations.readData(Constants.EXAM_DATA);
            for(String line : lines) {
                if(line.contains(examDatailsToUpdate.getTestName()) && line.contains(examDatailsToUpdate.getStudRollNum())){
                    line = mapExamsModelToString(examDatailsToUpdate);
                }
                if(!line.contains("\r\n")){
                    line = line + "\r\n";
                }
                FileOperations.saveData("ExamData_Temp.txt", line);
            }
            FileOperations.renameFile(Constants.EXAM_DATA, "ExamData_Temp.txt");
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while updating exams data - " + ex);
            return false;
        }
        return  true;
    }

    public static boolean delete(ExamData examDatailsToDelete) {
        try {
            List<String> lines = FileOperations.readData(Constants.EXAM_DATA);
            for(String line : lines) {
                if(line.contains(examDatailsToDelete.getClassName()) && line.contains(examDatailsToDelete.getTestName()) &&
                        line.contains(examDatailsToDelete.getStudRollNum())){
                    continue;
                }
                if(!line.contains("\r\n")){
                    line = line + "\r\n";
                }
                FileOperations.saveData("ExamData_Temp.txt", line);
            }
            FileOperations.renameFile(Constants.COURSE_DATA, "ExamData_Temp.txt");
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while deleting exam datails - " + ex);
            return false;
        }
        return  true;
    }

    public static ExamData mapLinesToExamsModel(String data){
        String splitData[] = data.split(",");
        ExamData examDetails = new ExamData();
        examDetails.setStudRollNum(splitData[0]);
        examDetails.setClassName(splitData[1]);
        examDetails.setTestName(splitData[2]);
        examDetails.setSub1Name(splitData[3]);
        examDetails.setSub1Score(splitData[4]);
        examDetails.setSub2Name(splitData[5]);
        examDetails.setSub2Score(splitData[6]);
        examDetails.setSub3Name(splitData[7]);
        examDetails.setSub3Score(splitData[8]);
        examDetails.setSub4Name(splitData[9]);
        examDetails.setSub4Score(splitData[10]);
        examDetails.setSub5Name(splitData[11]);
        examDetails.setSub5Score(splitData[12]);
        examDetails.setSub6Name(splitData[13]);
        examDetails.setSub6Score(splitData[14]);

        return examDetails;
    }

    public static String mapExamsModelToString(ExamData examDetails){
        StringBuilder data = new StringBuilder();
        data.append(examDetails.getStudRollNum());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getClassName());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getTestName());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub1Name());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub1Score());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub2Name());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub2Score());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub3Name());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub3Score());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub4Name());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub4Score());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub5Name());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub5Score());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub6Name());
        data.append(Constants.SEPARATOR);
        data.append(examDetails.getSub6Score());
        data.append("\r\n");
        return data.toString();
    }


}
