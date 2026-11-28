/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
// Keeps all the employee data in memory and does the work: load the file, sort, search, validate + add new employees, build the tree.
public class EmployeeStore {
 // file order first, new employees are added at the end (the tree uses this order)
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    // only the employees added while the program is running
    private ArrayList<Employee> newRecords = new ArrayList<Employee>();

    // sorted copy used for showing the names and for binary search
    private Employee[] sortedArray = new Employee[0];
    private boolean sorted = false;

    private int skippedLines = 0;

    // file
    public void loadFile(String filename) throws FileNotFoundException {
        FileHandler handler = new FileHandler();
        employees = handler.readEmployees(filename);   // throws if the file does not exist
        skippedLines = handler.getSkippedLines();
        newRecords.clear();
        sorted = false;
    }

    // sort
    public void sortEmployees() {
        sortedArray = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            sortedArray[i] = employees.get(i);
        }

        MergeSorter.mergeSort(sortedArray, 0, sortedArray.length - 1);
        sorted = true;
    }

    // search
    // returns the employee or null if the name is not in the list
    public Employee searchByName(String name) {
        // binary search needs a sorted list
        if (!sorted) {
            sortEmployees();
        }

        String target = Employee.cleanName(name);
        int index = BinarySearcher.binarySearch(sortedArray, 0, sortedArray.length - 1, target);

        if (index == -1) {
            return null;
        }
        return sortedArray[index];
    }

    //add new employee
    // returns an error message, or null if the name is ok
    public String checkName(String rawName) {
        String name = Employee.cleanName(rawName);

        if (name.equals("")) {
            return "Name cannot be empty.";
        }
        if (!Employee.hasValidCharacters(name)) {
            return "Name can only contain letters, spaces, hyphens and apostrophes.";
        }
        if (!Employee.hasFirstAndLastName(name)) {
            return "Please enter both a first name and a last name.";
        }
        if (searchByName(name) != null) {
            return "That employee is already in the list.";
        }
        return null;
    }

    // the name, manager type and department are checked before this is called
    public void addEmployee(String rawName, ManagerType managerType, Department department) {
        String name = Employee.formatName(Employee.cleanName(rawName));

        Employee employee = new Employee(name, managerType, department);
        employees.add(employee);
        newRecords.add(employee);

        // the sorted copy does not have the new employee, it will be sorted again when needed
        sorted = false;
    }

    // binary tree
    // inserts the first "howMany" employees (in file order) into a new tree
    public EmployeeBinaryTree buildTree(int howMany) {
        EmployeeBinaryTree tree = new EmployeeBinaryTree();
        for (int i = 0; i < howMany && i < employees.size(); i++) {
            tree.insert(employees.get(i));
        }
        return tree;
    }

    // getters
    public boolean isSorted() {
        return sorted;
    }

    public Employee[] getSortedArray() {
        return sortedArray;
    }

    public ArrayList<Employee> getNewRecords() {
        return newRecords;
    }

    public int getEmployeeCount() {
        return employees.size();
    }

    public int getSkippedLines() {
        return skippedLines;
    }
}
