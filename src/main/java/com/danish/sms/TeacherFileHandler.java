package com.danish.sms;

import java.io.*;

public class TeacherFileHandler {

    private static final String FILE_PATH = "teacher_data.txt";

    public static void writeTeacherToFile(Teacher teacher) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(teacher);
            System.out.println("Teacher data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing teacher data to file.");
        }
    }

    public static Teacher readTeacherFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Teacher loadedTeacher = (Teacher) inputStream.readObject();
            System.out.println("Teacher data loaded from file:");
            System.out.println(loadedTeacher);
            return loadedTeacher;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading teacher data from file.");
            return null;
        }
    }
}
