package in.pentagon.studentapp.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import in.ps.Studentapp.dto.Student;

public class CSVExporter {
    public static void exportStudentsToCSV(List<Student> students, String path) {
 
        try (FileWriter writer = new FileWriter(path)) {
            writer.append("ID,Name,Phone,Mail,Branch,Location,Password,Date\n");
            for (Student s : students) {
                writer.append(s.getId() + "," + s.getName() + "," + s.getPhone() + "," +
                              s.getMail() + "," + s.getBranch() + "," + s.getLoc() + "," +
                              s.getPassword() + "," + s.getDate() + "\n");
            }
            System.out.println("CSV exported to: " + path);
        } catch (IOException e) {
            System.out.println("Error exporting CSV: " + e.getMessage());
        }
    }
}
