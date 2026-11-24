/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dylan
 */
// reads the employees from the text file
public class FileHandler {

    public static ArrayList<Employee> readEmployees(String filename) throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();
        
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                // columns: First name, Last name, Gender, Email, Salary,
                // Department, Position, Job title, Company
                String[] parts = line.split(",");
                if (parts.length >= 8) {
                    String fullName = parts[0].trim() + " " + parts[1].trim();
                    String department = parts[5].trim();
                    String managerType = parts[7].trim();   // job title column
                    
                    employees.add(new Employee(fullName, managerType, department));
                }
            }
        }
        return employees;
    }
}