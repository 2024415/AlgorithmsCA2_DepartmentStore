/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
//the options that shown in the main menu
public enum MenuOption {
    SORT("SORT"),
    SEARCH("SEARCH"),
    ADD_RECORDS("ADD RECORDS"),
    CREATE_BINARY_TREE("CREATE A BINARY TREE"),
    EXIT("EXIT");

    private final String label;

    MenuOption(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    // turns the number the user typed (1, 2, 3...) into a menu option
    // returns null if the number is not on the menu
    public static MenuOption fromChoice(int choice) {
        MenuOption[] options = MenuOption.values();
        if (choice >= 1 && choice <= options.length) {
            return options[choice - 1];
        }
        return null;
    }
}
