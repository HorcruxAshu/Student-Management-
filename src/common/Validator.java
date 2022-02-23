package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validator {
    // Validate if input text contains only digits
    public static boolean isNumeric(String text) {
        if(text.isEmpty()){
            return true;
        }
        return (text.matches("[0-9]+"));
    }

    // Validate if input text contains only alphabets
    public static boolean isAlphabet(String text) {
        text = text.replace(" ", "");
        return (text.matches("[a-zA-Z]+"));
    }

    public static boolean isAlphaNumeric(String text){
        text = text.replace(" ", "");
        return (text.matches("[a-zA-Z0-9_+&*-]+"));
    }

    // Validate if input is in expected dateformat, i.e dd/MM/yyyy.
    public static boolean isDateValid(String dateToValidate) {
        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    // Validate if input is in expected email format.
    public static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
            + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return (pat.matcher(email).matches() && (email.substring(0, email.indexOf("@")).length() <= 25)
            && (email.substring(email.indexOf("@") + 1, email.lastIndexOf(".")).length() <= 35));
    }

}

