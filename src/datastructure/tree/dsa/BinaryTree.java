package datastructure.tree.dsa;

import java.util.Scanner;

public class BinaryTree {
    private Node root;
    private static final String POPULATE_HELPER = "15 true 6 true 8 false true 10 false false true 14 false false true 9 false false";
    private static final Scanner get = new Scanner(POPULATE_HELPER);

    public void populate() {
        System.out.println("Enter root node value : ");
        int value = get.nextInt();
        root = new Node(value);
        populate(root);
    }

    private void populate(Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        if(get.nextBoolean()) {
            Node left = new Node();
            System.out.println("Enter left value of " + node.value + " : ");
            left.value = get.nextInt();
            node.left = left;
            populate(left);
        }
        System.out.println("Do you want to enter right of " + node.value);
        if(get.nextBoolean()) {
            Node right = new Node();
            System.out.println("Enter right value of " + node.value + " : ");
            right.value = get.nextInt();
            node.right = right;
            populate(right);
        }
    }

    public void display() {
        display("Root Node : ", root);
    }

    private void display(String desc, Node node) {
        if(node == null) {
            return;
        }

        System.out.println(desc + node.value);
        display("Left of " + node.value + " : ", node.left);
        display("Right of " + node.value + " : ", node.right);
    }

    public void prettyDisplay() {
        prettyDisplay(root);
    }

    public static void prettyDisplay(Node node) {
        prettyDisplay(node, 0);
    }

    private static void prettyDisplay(Node node, int level) {
        if(node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);
        if(level == 0) {
            System.out.println(node.value + "------>");
        } else {
            for(int i = 0; i < level; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.print(node.value + "   ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + "   ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + "   ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.populate();
//        tree.display();
//        tree.prettyDisplay();
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
    }
}
