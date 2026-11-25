/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.view;

import algorithmsca2_departmentstore.model.Department;
import algorithmsca2_departmentstore.model.Employee;
import algorithmsca2_departmentstore.model.ManagerType;
import algorithmsca2_departmentstore.model.MenuOption;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dylan
 */

public class ConsoleView {

    private final Scanner input = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readText(String message) {
        System.out.print(message);
        return input.nextLine().trim();
    }

    // keeps asking until the user types a whole number
    public int readNumber(String message) {
        while (true) {
            String text = readText(message);
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    // the menu is built by looping through the MenuOption enum
    public void showMenu() {
        System.out.println();
        System.out.println("=== Grand Central Department Store ===");
        System.out.println("Do you wish to SORT or SEARCH:");

        MenuOption[] options = MenuOption.values();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i].getLabel());
        }
    }

    // shows only the names, for the first "howMany" people in the list
    public void showNames(ArrayList<Employee> list, int howMany) {
        for (int i = 0; i < list.size() && i < howMany; i++) {
            System.out.println((i + 1) + ". " + list.get(i).getFullName());
        }
    }

    public void showEmployeeDetails(Employee employee) {
        System.out.println("Person found:");
        System.out.println("  Name:         " + employee.getFullName());
        System.out.println("  Manager Type: " + employee.getManagerType());
        System.out.println("  Department:   " + employee.getDepartment());
    }

    // lists the manager types by looping through the ManagerType enum
    public void showManagerTypes() {
        System.out.println("Manager types:");
        ManagerType[] types = ManagerType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println("  " + (i + 1) + ". " + types[i].getDisplayName());
        }
    }

    // lists the departments by looping through the Department enum
    public void showDepartments() {
        System.out.println("Departments:");
        Department[] departments = Department.values();
        for (int i = 0; i < departments.length; i++) {
            System.out.println("  " + (i + 1) + ". " + departments[i].getDisplayName());
        }
    }

    public void showNewRecords(ArrayList<Employee> newRecords) {
        System.out.println("New records added so far (" + newRecords.size() + "):");
        for (int i = 0; i < newRecords.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + newRecords.get(i));
        }
    }

    public void showTree(ArrayList<ArrayList<Employee>> levels, int height, int nodeCount) {
        System.out.println("Employee hierarchy (level order):");

        for (int i = 0; i < levels.size(); i++) {
            System.out.println("Level " + (i + 1) + ":");
            ArrayList<Employee> level = levels.get(i);
            for (int j = 0; j < level.size(); j++) {
                System.out.println("  " + level.get(j));
            }
        }

        System.out.println();
        System.out.println("Tree height: " + height + " levels");
        System.out.println("Total nodes: " + nodeCount);
    }
}