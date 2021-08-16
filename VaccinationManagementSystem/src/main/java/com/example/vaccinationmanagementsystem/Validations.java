package com.example.vaccinationmanagementsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    public static boolean isEcuadorianDocumentValid(String document) {
        byte sum = 0;
        try {
            if (document.trim().length() != 10)
                return false;
            String[] data = document.split("");
            byte verifier = Byte.parseByte(data[0] + data[1]);
            if (verifier < 1 || verifier > 24)
                return false;
            byte[] digits = new byte[data.length];
            for (byte i = 0; i < digits.length; i++)
                digits[i] = Byte.parseByte(data[i]);
            if (digits[2] > 6)
                return false;
            for (byte i = 0; i < digits.length - 1; i++) {
                if (i % 2 == 0) {
                    verifier = (byte) (digits[i] * 2);
                    if (verifier > 9)
                        verifier = (byte) (verifier - 9);
                } else
                    verifier = (byte) (digits[i]);
                sum = (byte) (sum + verifier);
            }
            if ((sum - (sum % 10) + 10 - sum) == digits[9])
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isUsernameValid(String userName){

        boolean state = false;
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_-]{6,16}$");
        Matcher mat = pat.matcher(userName);

        return mat.matches() ? true : false;
    }

    public static boolean isEmailValid(String emailStr){

        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
            return matcher.find();
    }

    public static boolean isNameOrLastValid(String s){
        Pattern pattern = Pattern.compile("[a-zA-Z]{2,12}$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches() ? true : false;
    }
}
