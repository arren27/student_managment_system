package StudentManagment;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class studentmanagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Student class
    static class Student {
        int rollNo;
        String name;
        String branch;
        double cgpa;
        int year;

        Student(int rollNo, String name, String branch, double cgpa) {
            this.rollNo = rollNo;
            this.name = name;
            this.branch = branch;
            this.cgpa = cgpa;

        }
        public int getRollNo(){ return rollNo;}

    public String getName(){ return name;}

    public double getcgpa(){ return cgpa; }

    public String getBranch(){ return branch;}

    //Setters

    public void setName(String name) { this.name = name;}
    public void setBranch(String branch) { this.branch = branch;}
    public void setYear(int year){ this.year=year;}




    }
     static void savetofile(){
        try{
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("c:\\Users\\Asus\\Desktop\\vap\\students.csv"));

                for (Student s :students){
                    bw.write(s.getRollNo()+","+s.getName()+","+
                    s.getBranch()+","+s.getcgpa());
                    bw.newLine();

                }
            
                bw.close();
                System.out.println("File saved successfully!");
            } catch (IOException ex){
                System.out.println("ERROR: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    // MAIN METHOD
    public static void main(String[] args) {
        loadFromFile();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by roll no");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    addStudent();
                    savetofile();
                }
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> {
                    updateStudent();
                    savetofile();
                }
                case 5 -> {
                    deleteStudent();
                    savetofile();
                }
                case 6 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Please enter a valid choice (1-6)");
            }
        }
    }

    // ADD STUDENT
    static void addStudent() {
        System.out.print("Enter roll no: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        students.add(new Student(roll, name, branch, cgpa));
        System.out.println("Student added successfully!");
    }

    // VIEW STUDENTS
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nRoll | Name | Branch | CGPA");
        for (Student s : students) {
            System.out.println(
                s.rollNo + " | " +
                s.name + " | " +
                s.branch + " | " +
                s.cgpa
            );
        }
    }

    // SEARCH STUDENT
    static void searchStudent() {
        System.out.print("Enter roll no to search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.println("Student Found:");
                System.out.println(s.rollNo + " | " + s.name + " | " + s.branch + " | " + s.cgpa);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // UPDATE STUDENT
    static void updateStudent() {
        System.out.print("Enter roll no to update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new branch: ");
                s.branch = sc.nextLine();

                System.out.print("Enter new CGPA: ");
                s.cgpa = sc.nextDouble();

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // DELETE STUDENT
    static void deleteStudent() {
        System.out.print("Enter roll no to delete: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
    static void loadFromFile() {
    try {
        File file = new File("c:\\Users\\Asus\\Desktop\\vap\\students.csv");
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            try {
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
                students.add(new Student(
                    Integer.parseInt(parts[0].trim()), 
                    parts[1].trim(),
                    parts[2].trim(), 
                    Double.parseDouble(parts[3].trim())));
            } catch (NumberFormatException e) {
                System.out.println("Error parsing line: " + line + " - " + e.getMessage());
            }
        }
        br.close();
    } catch (IOException ex) {
        System.out.println("ERROR loading file: " + ex.getMessage());
        ex.printStackTrace();
    }
}

}
