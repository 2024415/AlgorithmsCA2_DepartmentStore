/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
// one employee of the department store + small helper methods for names
public class Employee {

    private String fullName;
    private ManagerType managerType;
    private Department department;

    public Employee(String fullName, ManagerType managerType, Department department) {
        this.fullName = fullName;
        this.managerType = managerType;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public Department getDepartment() {
        return department;
    }

    // "  john    smith " -> "john smith"
    public static String cleanName(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    // only letters, spaces, hyphens and apostrophes are allowed
    public static boolean hasValidCharacters(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'') {
                return false;
            }
        }
        return true;
    }

    // there must be a first name and a last name
    public static boolean hasFirstAndLastName(String name) {
        return name.indexOf(' ') != -1;
    }

    // "anna-marie o'neil" -> "Anna-Marie O'Neil"
    // capital letter at the start of the name and after a space, - or '
    public static String formatName(String name) {
        String result = "";
        boolean capitalNext = true;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (capitalNext) {
                result = result + Character.toUpperCase(c);
            } else {
                result = result + Character.toLowerCase(c);
            }
            capitalNext = (c == ' ' || c == '-' || c == '\'');
        }
        return result;
    }

    @Override
    public String toString() {
        return fullName + " | " + managerType.getDisplayName() + " | " + department.getDisplayName();
    }
}
