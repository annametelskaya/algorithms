package bsu.mmf.algorithms.lab2b;

public class Tree {
    public static Node root;

    public Tree() {
        this.root = null;
    }

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    private Node insertion(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else {
            if (value >= node.data) {
                node.right = insertion(node.right, value);
            } else {
                node.left = insertion(node.left, value);
            }
        }
        return node;
    }

    public void insert(int value) {
        root = insertion(root, value);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}

