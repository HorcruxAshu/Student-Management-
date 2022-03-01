package pojo;

import common.Constants;
import common.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseData {
    String className;
    String sub1;
    String sub2;
    String sub3;
    String sub4;
    String sub5;
    String sub6;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSub1() {
        return sub1;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    public String getSub3() {
        return sub3;
    }

    public void setSub3(String sub3) {
        this.sub3 = sub3;
    }

    public String getSub4() {
        return sub4;
    }

    public void setSub4(String sub4) {
        this.sub4 = sub4;
    }

    public String getSub5() {
        return sub5;
    }

    public void setSub5(String sub5) {
        this.sub5 = sub5;
    }

    public String getSub6() {
        return sub6;
    }

    public void setSub6(String sub6) {
        this.sub6 = sub6;
    }

    public static List<CourseData> getAllCourseDetails(){
        List<CourseData> allCourses = new ArrayList<>();
        try {
            List<String> lines = FileOperations.readData(Constants.COURSE_DATA);
            for(String line : lines) {
                CourseData data = mapLinesToCourseModel(line);
                allCourses.add(data);
            }
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while reading course data - " + ex);
        }
        return allCourses;
    }

    public static List<String> getAllClasses(){
        List<CourseData> classes = getAllCourseDetails();
        List<String> allClasses = classes.stream()
                .map(CourseData::getClassName)
                .collect(Collectors.toList());
        return allClasses;
    }

    public static CourseData getCourseDetailsByName(String name){
        return getAllCourseDetails().stream()
                .filter(x ->x.getClassName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static boolean add(CourseData course){
        String courseData = mapCourseModelToString(course);

        if(!FileOperations.saveData(Constants.COURSE_DATA, courseData)){
            return false;
        }
        return true;
    }

    public static boolean update(CourseData courseToUpdate) {
        try {
            List<String> lines = FileOperations.readData(Constants.COURSE_DATA);
            for(String line : lines) {
                if(line.contains(courseToUpdate.getClassName())){
                    line = mapCourseModelToString(courseToUpdate);
                }
                if(!line.contains("\r\n")){
                    line = line + "\r\n";
                }
                FileOperations.saveData("CourseData_Temp.txt", line);
            }
            FileOperations.renameFile(Constants.COURSE_DATA, "CourseData_Temp.txt");
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while updating course data - " + ex);
            return false;
        }
        return  true;
    }

    public static boolean delete(CourseData courseToDelete) {
        try {
            List<String> lines = FileOperations.readData(Constants.COURSE_DATA);
            for(String line : lines) {
                if(line.contains(courseToDelete.getClassName())){
                    continue;
                }
                if(!line.contains("\r\n")){
                    line = line + "\r\n";
                }
                FileOperations.saveData("CourseData_Temp.txt", line);
            }
            FileOperations.renameFile(Constants.COURSE_DATA, "CourseData_Temp.txt");
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while updating books data - " + ex);
            return false;
        }
        return  true;
    }

    public static CourseData mapLinesToCourseModel(String data){
        String splitData[] = data.split(",");
        CourseData course = new CourseData();
        course.setClassName(splitData[0]);
        course.setSub1(splitData[1]);
        course.setSub2(splitData[2]);
        course.setSub3(splitData[3]);
        course.setSub4(splitData[4]);
        course.setSub5(splitData[5]);
        course.setSub6(splitData[6]);

        return course;
    }

    public static String mapCourseModelToString(CourseData course){
        StringBuilder data = new StringBuilder();
        data.append(course.getClassName());
        data.append(Constants.SEPARATOR);
        data.append(course.getSub1());
        data.append(Constants.SEPARATOR);
        data.append(course.getSub2());
        data.append(Constants.SEPARATOR);
        data.append(course.getSub3());
        data.append(Constants.SEPARATOR);
        data.append(course.getSub4());
        data.append(Constants.SEPARATOR);
        data.append(course.getSub5());
        data.append(Constants.SEPARATOR);
        data.append(course.getSub6());
        data.append(Constants.SEPARATOR);
        data.append("\r\n");
        return data.toString();
    }
}
