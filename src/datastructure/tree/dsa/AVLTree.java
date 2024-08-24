package datastructure.tree.dsa;

public class AVLTree {
    private Node root;

    private int height(Node node) {
        if(node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
         root = this.insert(root, value);
    }

    private Node insert(Node node, int value) {
        if(node == null) {
            Node newNode = new Node();
            newNode.value = value;
            return newNode;
        }

        if(node.value < value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return this.balance(node);
    }

    private Node balance(Node node) {
        // Unbalanced of left side
        if(height(node.left) - height(node.right) > 1) {
            // Left left case
            if(height(node.left.left) > height(node.left.right)) {
                return rightRotate(node);
            }

            // Left Right case
            if(height(node.left.left) < height(node.left.right)) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Unbalanced of right side
        if(height(node.left) - height(node.right) < 0) {
            // Right Right case
            if(height(node.right.left) < height(node.right.right)) {
                return leftRotate(node);
            }

            // Right Left case
            if(height(node.right.left) > height(node.right.right)) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node tree = child.right;

        child.right = parent;
        parent.left = tree;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }


    private Node leftRotate(Node parent) {
        Node child = parent.right;
        Node tree = child.left;

        child.left = parent;
        parent.right = tree;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }


    public void clearTree() {
        this.root = null;
    }

    // --------------------------------------------------------------

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for(int i : arr) {
            tree.insert(i);
        }
        BinaryTree.prettyDisplay(tree.root);
    }

}
