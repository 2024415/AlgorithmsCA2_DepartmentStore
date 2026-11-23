/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
//one staff in the department store
public class Employee {

    private final String fullName;
    private final String managerType;
    private final String department;

    public Employee(String fullName, String managerType, String department) {
        this.fullName = fullName;
        this.managerType = managerType;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public String getManagerType() {
        return managerType;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return fullName + " | " + managerType + " | " + department;
    }
}
