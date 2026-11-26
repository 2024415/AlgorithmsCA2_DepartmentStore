/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
// departments of the department store
public enum Department {
    SALES("Sales"),
    CUSTOMER_SERVICE("Customer Service"),
    OPERATIONS("Operations"),
    HR("HR"),
    FINANCE("Finance"),
    MARKETING("Marketing"),
    IT_DEVELOPMENT("IT Development"),
    ACCOUNTING("Accounting"),
    TECHNICAL_SUPPORT("Technical Support");

    private String displayName;

    Department(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // number from the menu (1 - 9) to the enum, null if the number does not exist
    public static Department fromChoice(int choice) {
        Department[] departments = Department.values();
        if (choice >= 1 && choice <= departments.length) {
            return departments[choice - 1];
        }
        return null;
    }

    // text from the file to the enum, null if the department does not exist
    public static Department fromName(String name) {
        for (Department department : Department.values()) {
            if (department.displayName.equalsIgnoreCase(name.trim())) {
                return department;
            }
        }
        return null;
    }
}
