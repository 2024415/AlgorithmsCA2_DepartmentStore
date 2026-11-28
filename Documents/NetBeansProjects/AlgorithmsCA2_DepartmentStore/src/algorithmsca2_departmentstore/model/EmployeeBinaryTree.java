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
// Binary tree for the employee hierarchy of the department store.
// Employees are inserted in LEVEL ORDER (breadth first): fill left first, then right,and when a node has both children move to the next node in level order.
public class EmployeeBinaryTree {

    private TreeNode root;
    private int nodeCount;

    public EmployeeBinaryTree() {
        root = null;
        nodeCount = 0;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    // level order insertion using a queue
    public void insert(Employee employee) {
        TreeNode newNode = new TreeNode(employee);

        // first employee is the root
        if (root == null) {
            root = newNode;
            nodeCount++;
            return;
        }

        NodeQueue queue = new NodeQueue(nodeCount + 1);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.dequeue();

            // left child first
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                newNode.setLevel(current.getLevel() + 1);
                nodeCount++;
                return;
            } else {
                queue.enqueue(current.getLeft());
            }

            // then right child
            if (current.getRight() == null) {
                current.setRight(newNode);
                newNode.setLevel(current.getLevel() + 1);
                nodeCount++;
                return;
            } else {
                queue.enqueue(current.getRight());
    }
            }
        }

    // level order traversal, returns the nodes in level order (level 1, then level 2, ...)
    public ArrayList<TreeNode> getLevelOrder() {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();

        if (root == null) {
            return result;
        }

        NodeQueue queue = new NodeQueue(nodeCount + 1);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.dequeue();
            result.add(current);

            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }
        return result;
    }

    // height = number of levels (only the root = height 1, empty tree = 0)
    public int getHeight() {
        return height(root);
    }

    private int height(TreeNode node) {
        // Base case
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    // total number of nodes, counted recursively
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