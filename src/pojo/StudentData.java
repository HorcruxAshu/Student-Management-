package pojo;

import common.Constants;
import common.FileOperations;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentData {

    String rollNum;
    String firstName;
    String lastName;
    String dateOfBirth;
    String gender;
    String fatherName;
    String motherName;
    String homeTelephone;
    String mobileNumber;
    String address;
    String classStandard;

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassStandard() {
        return classStandard;
    }

    public void setClassStandard(String classStandard) {
        this.classStandard = classStandard;
    }

    public static List<StudentData> getAllStudents(){
        List<StudentData> allStudents = new ArrayList<>();
        try {
            List<String> lines = FileOperations.readData(Constants.STUDENT_DATA);
            for(String line : lines) {
                StudentData data = mapLinesToStudentModel(line);
                allStudents.add(data);
            }
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while reading student data - " + ex);
        }
        return allStudents;
    }

    public List<String> getAllRollNumbers(){
        List<StudentData> students = getAllStudents();
        List<String> allRollNumbers = students.stream()
            .map(StudentData::getRollNum)
            .collect(Collectors.toList());
        return allRollNumbers;
    }

    public static StudentData getStudentByRollNo(String rollno){
        return getAllStudents().stream()
            .filter(x ->x.getRollNum().equalsIgnoreCase(rollno))
            .findFirst()
            .orElse(null);
    }

    public static boolean add(StudentData newStudent){
        String studentData = mapStudentModelToString(newStudent);

        if(!FileOperations.saveData(Constants.STUDENT_DATA, studentData.toString())){
            return false;
        }
        return true;
    }

    public static boolean delete(StudentData studentToDelete) {
        try {
            List<String> lines = FileOperations.readData(Constants.STUDENT_DATA);
            for(String line : lines) {
                if(line.contains(studentToDelete.getRollNum())){
                    continue;
                }
                if(!line.contains("\r\n")){
                    line = line + "\r\n";
                }
                FileOperations.saveData("StudentData_Temp.txt", line);
            }
            FileOperations.renameFile(Constants.STUDENT_DATA, "StudentData_Temp.txt");
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while updating books data - " + ex);
            return false;
        }
        return  true;
    }

    public static StudentData mapLinesToStudentModel(String data){
        String splitData[] = data.split(",");
        StudentData studentModel = new StudentData();
        studentModel.setRollNum(splitData[0]);
        studentModel.setFirstName(splitData[1]);
        studentModel.setLastName(splitData[2]);
        studentModel.setGender(splitData[3]);
        studentModel.setDateOfBirth(splitData[4]);
        studentModel.setFatherName(splitData[5]);
        studentModel.setMotherName(splitData[6]);
        studentModel.setHomeTelephone(splitData[7]);
        studentModel.setMobileNumber(splitData[8]);
        studentModel.setAddress(splitData[9]);
        studentModel.setClassStandard(splitData[10]);
        return studentModel;
    }

    public static String mapStudentModelToString(StudentData student){
        StringBuilder data = new StringBuilder();
        data.append(student.getRollNum());
        data.append(Constants.SEPARATOR);
        data.append(student.getFirstName());
        data.append(Constants.SEPARATOR);
        data.append(student.getLastName());
        data.append(Constants.SEPARATOR);
        data.append(student.getGender());
        data.append(Constants.SEPARATOR);
        data.append(student.getDateOfBirth());
        data.append(Constants.SEPARATOR);
        data.append(student.getDateOfBirth());
        data.append(Constants.SEPARATOR);
        data.append(student.getFatherName());
        data.append(Constants.SEPARATOR);
        data.append(student.getMotherName());
        data.append(Constants.SEPARATOR);
        data.append(student.getHomeTelephone());
        data.append(Constants.SEPARATOR);
        data.append(student.getMobileNumber());
        data.append(Constants.SEPARATOR);
        data.append(student.getClassStandard());
        data.append("\r\n");
        return data.toString();
    }
}
