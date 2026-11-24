/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Dylan
 */
// binary tree of employees, filled level by level (breadth first)
public class EmployeeBinaryTree {

    private TreeNode root;

    // level order insert: look for the first node that has a free spot,
    // going level by level, filling left first and then right
    public void insert(Employee employee) {
        TreeNode newNode = new TreeNode(employee);

        // empty tree, so the new node is the root
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            }
            queue.add(current.getLeft());

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            }
            queue.add(current.getRight());
        }
    }

    // level order traversal, returns one list of employees for each level
    public ArrayList<ArrayList<Employee>> getLevelOrder() {
        ArrayList<ArrayList<Employee>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // everything in the queue right now belongs to the same level
            int levelSize = queue.size();
            ArrayList<Employee> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                level.add(node.getData());

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            levels.add(level);
        }
        return levels;
    }

    // height = number of levels (an empty tree has height 0)
    public int getHeight() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // total number of nodes
    public int countNodes() {
        return count(root);
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.getLeft()) + count(node.getRight());
    }
}
