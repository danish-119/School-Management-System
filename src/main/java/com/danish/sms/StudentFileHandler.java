package com.danish.sms;

import java.io.*;

public class StudentFileHandler {

    private static final String FILE_PATH = "student_data.txt";

    public static void writeStudentToFile(Student student) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(student);
            System.out.println("Student data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data to file.");
        }
    }

    public static Student readStudentFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Student loadedStudent = (Student) inputStream.readObject();
            System.out.println("Student data loaded from file:");
//            System.out.println(loadedStudent);
            return loadedStudent;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading student data from file.");
            return null;
        }
    }
}
