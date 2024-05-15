package com.danish.sms;

public class Validator {
    public static boolean isValidGender(String gender) {
        return gender.equals("Male") || gender.equals("Female") || gender.equals("Other");
    }

    public static boolean isValidJobType(String jobType) {
        return jobType.equals("Full-time") || jobType.equals("Part-time") || jobType.equals("Contract");
    }
}
