/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
// one node of the employee binary tree
public class TreeNode {

    private Employee data;    // the node stores Name, Manager Type and Department (inside Employee)
    private TreeNode left;
    private TreeNode right;
    private int level;        // root is level 1

    public TreeNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.level = 1;
    }

    public Employee getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}