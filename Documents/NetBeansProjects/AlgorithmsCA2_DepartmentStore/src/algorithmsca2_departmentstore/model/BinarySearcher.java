/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

import java.util.ArrayList;

/**
 *
 * @author Dylan
 */

public class BinarySearcher {

    // returns the employee with this name, or null if the name is not in the list
    public static Employee search(ArrayList<Employee> list, String name) {
        return searchRange(list, name.trim(), 0, list.size() - 1);
    }

    private static Employee searchRange(ArrayList<Employee> list, String name, int low, int high) {

        // base case: nothing left to look at, so the name is not there
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        int result = list.get(mid).getFullName().compareToIgnoreCase(name);

        if (result == 0) {
            return list.get(mid);                           // found it
        } else if (result > 0) {
            return searchRange(list, name, low, mid - 1);   // name is in the left half
        } else {
            return searchRange(list, name, mid + 1, high);  // name is in the right half
        }
    }
}
