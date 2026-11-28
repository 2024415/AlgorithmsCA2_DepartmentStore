/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsca2_departmentstore.model;

/**
 *
 * @author Dylan
 */
// Array queue
public class NodeQueue {
    
    private TreeNode[] queue;
    private int front, rear, size;

    public NodeQueue(int size) {
        this.size = size;
        this.queue = new TreeNode[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(TreeNode node) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = node;
        }
    }

    public TreeNode dequeue() {
        if (isEmpty()) {
            return null;
        }
        TreeNode node = queue[front];
        if (front == rear) {
            front = rear = -1;   // queue is empty again
        } else {
            front++;
        }
        return node;
    }
}
    

