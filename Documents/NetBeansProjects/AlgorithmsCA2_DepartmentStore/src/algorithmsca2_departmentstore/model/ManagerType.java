/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
//
public enum ManagerType {
    HEAD_MANAGER("Head Manager"),
    SENIOR_MANAGER("Senior Manager"),
    MANAGER("Manager"),
    ASSISTANT_MANAGER("Assistant Manager"),
    TEAM_LEAD("Team Lead"),
    STAFF("Staff");

    private String displayName;

    ManagerType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // returns null if the number is not a valid manager type
    public static ManagerType fromChoice(int choice) {
        ManagerType[] types = ManagerType.values();
        if (choice >= 1 && choice <= types.length) {
            return types[choice - 1];
        }
        return null;
    }
}