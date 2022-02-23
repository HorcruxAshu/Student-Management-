package pojo;

import common.Constants;
import common.FileOperations;
import java.util.ArrayList;
import java.util.List;

public class LoginData {
    String name;
    String userName;
    String password;
    String classStandard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassStandard() {
        return classStandard;
    }

    public void setClassStandard(String classStandard) {
        this.classStandard = classStandard;
    }

    public static List<LoginData> getAllCredentials(){
        List<LoginData> allCreds = new ArrayList<>();
        try {
            List<String> lines = FileOperations.readData(Constants.LOGIN_DATA);
            for(String line : lines) {
                LoginData data = mapLinesToLoginDataModel(line);
                allCreds.add(data);
            }
        } catch (Exception ex){
            // log an exception
            System.out.println("exception while reading login data - " + ex);
        }
        return allCreds;
    }

    public static LoginData mapLinesToLoginDataModel(String data){
        String splitData[] = data.split(",");
        LoginData loginModel = new LoginData();
        loginModel.setName(splitData[0]);
        loginModel.setUserName(splitData[1]);
        loginModel.setPassword(splitData[2]);
        loginModel.setClassStandard(splitData[3]);
        return loginModel;
    }

    public static String mapLoginDataModelToString(LoginData loginData){
        StringBuilder data = new StringBuilder();
        data.append(loginData.getName());
        data.append(Constants.SEPARATOR);
        data.append(loginData.getUserName());
        data.append(Constants.SEPARATOR);
        data.append(loginData.getPassword());
        data.append(Constants.SEPARATOR);
        data.append(loginData.getClassStandard());
        data.append("\r\n");
        return data.toString();
    }
}
