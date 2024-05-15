package com.danish.sms;

import java.io.*;

public class StaffFileHandler {

    private static final String FILE_PATH = "staff_data.txt";

    public static void writeStaffToFile(Staff staff) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(staff);
            System.out.println("Staff data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing staff data to file.");
        }
    }

    public static Staff readStaffFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Staff loadedStaff = (Staff) inputStream.readObject();
            System.out.println("Staff data loaded from file:");
//            System.out.println(loadedStaff);
            return loadedStaff;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading staff data from file.");
            return null;
        }
    }
}
