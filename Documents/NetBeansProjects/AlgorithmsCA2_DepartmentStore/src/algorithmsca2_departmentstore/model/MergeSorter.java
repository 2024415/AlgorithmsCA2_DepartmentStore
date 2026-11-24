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

public class MergeSorter {

    // sorts the list A to Z by full name (ignoring upper/lower case)
    public static void mergeSort(ArrayList<Employee> list, int left, int right) {

        // base case: 0 or 1 element is already sorted
        if (left < right) {
            int mid = (left + right) / 2;

            // sort the left half and the right half
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            // join the two sorted halves
            merge(list, left, mid, right);
        }
    }

    public static void merge(ArrayList<Employee> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // copy the two halves into temporary lists
        ArrayList<Employee> L = new ArrayList<>();
        ArrayList<Employee> R = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            L.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            R.add(list.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;

        // take the smaller name each time
        while (i < n1 && j < n2) {
            String leftName = L.get(i).getFullName();
            String rightName = R.get(j).getFullName();

            if (leftName.compareToIgnoreCase(rightName) <= 0) {
                list.set(k, L.get(i));
                i++;
            } else {
                list.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // copy what is left over
        while (i < n1) {
            list.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            list.set(k, R.get(j));
            j++;
            k++;
        }
    }
}
