/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
//the departments in the store
public enum Department {
    SALES ("Sales"),
    MARKETING ("Marketing"),
    CUSTOMER_SERVICE ("Customer Service"),
    OPERATIONS ("Operations"),
    HUMAN_RESOURCES ("HR"),
    FINANCE ("Finance"),
    IT_DEPARTMENT ("IT"),
    ACCOUNTING ("Accounting"),
    TECHNICAL_SUPPORT ("Technical Support");
    
    private final String displayName;
    
    Department (String displayName) {
        this.displayName = displayName;
}
    
    public String getDisplayName() {
        return displayName;
    }
   
    //return null if the number is not a valid department
    public static Department fromChoice (int choice) {
        Department[] departments = Department.values();
        if (choice >= 1 && choice <= departments.length) {
            return departments[choice -1];
        }
        return null;
    }
    
}
