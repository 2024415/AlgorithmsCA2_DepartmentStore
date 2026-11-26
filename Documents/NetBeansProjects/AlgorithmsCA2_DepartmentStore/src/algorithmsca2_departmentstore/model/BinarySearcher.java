/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */

public class BinarySearcher {

    // returns the index of the employee, or -1 if not found
    public static int binarySearch(Employee[] arr, int left, int right, String target) {
        // Base case: not found
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int result = target.compareToIgnoreCase(arr[mid].getFullName());

        if (result == 0) {
            return mid;   // found
        }
        if (result < 0) {
            return binarySearch(arr, left, mid - 1, target);   // left half
        } else {
            return binarySearch(arr, mid + 1, right, target);  // right half
        }
    }
}
