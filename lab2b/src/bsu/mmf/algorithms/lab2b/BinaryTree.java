package bsu.mmf.algorithms.lab2b;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(Node newNode, Node rootTree) {

        if (this.getRoot() == null) {
            setRoot(newNode);
            return;
        }
        if (rootTree == null) {
            rootTree = new Node(newNode.getNumber(), newNode.getLeft(), newNode.getRight());
        } else {
            if (rootTree.getNumber() < newNode.getNumber()) {
                rootTree.setCountNodeRight(rootTree.getCountNodeRight() + 1);
                insert(newNode, rootTree.getRight());
                if (rootTree.getRight() == null) {
                    rootTree.setRight(newNode);
                }
            } else {
                rootTree.setCountNodeLeft(rootTree.getCountNodeLeft() + 1);
                insert(newNode, rootTree.getLeft());
                if (rootTree.getLeft() == null) {
                    rootTree.setLeft(newNode);
                }
            }
        }
    }


    public Node searchParent(int number, Node root) {
        if (root == null) {
            return null;
        }

        if (root.getLeft() != null)
            if (root.getLeft().getNumber() == number)
                return root;
        if (root.getRight() != null)
            if (root.getRight().getNumber() == number)
                return root;
        if (root.getNumber() < number)
            return searchParent(number, root.getRight());
        else return searchParent(number, root.getLeft());
    }

    public void rotationLeft(Node node) {
        if (node == null) return;
        if (node.getRight() != null) {
            Node tmp = new Node(node.getNumber());
            node.setNumber(node.getRight().getNumber());
            node.getRight().setNumber(tmp.getNumber());

            tmp = node.getLeft();
            node.setLeft(node.getRight().getLeft());
            node.getRight().setLeft(tmp);

            tmp = node.getRight();
            node.setRight(node.getLeft());
            node.setLeft(tmp);

            tmp = tmp.getRight();
            node.getLeft().setRight(node.getRight());
            node.setRight(tmp);

            node.setCountNodeRight(node.getLeft().getCountNodeRight());
            node.getLeft().setCountNodeRight(node.getLeft().getCountNodeLeft());
            node.getLeft().setCountNodeLeft(node.getCountNodeLeft());
            node.setCountNodeLeft(node.getLeft().getCountNodeLeft() + node.getLeft().getCountNodeRight() + 1);
        }
    }

    public void rotationRight(Node node) {
        if (node == null) return;
        if (node.getLeft() != null) {
            Node tmp = new Node(node.getNumber());
            node.setNumber(node.getLeft().getNumber());
            node.getLeft().setNumber(tmp.getNumber());

            tmp = node.getRight();
            node.setRight(node.getLeft().getRight());
            node.getLeft().setRight(tmp);

            tmp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(tmp);

            tmp = tmp.getLeft();
            node.getRight().setLeft(node.getLeft());
            node.setLeft(tmp);

            node.setCountNodeLeft(node.getRight().getCountNodeLeft());
            node.getRight().setCountNodeLeft(node.getRight().getCountNodeRight());
            node.getRight().setCountNodeRight(node.getCountNodeRight());
            node.setCountNodeRight(node.getRight().getCountNodeRight() + node.getRight().getCountNodeLeft() + 1);
        }
    }

    public void insertIntoRoot(int number, Node root) {
        Node newNode = new Node(number);
        insert(newNode, getRoot());

        Node parent = getRoot();
        boolean rotation;
        while (getRoot().getNumber() != number) {
            parent = searchParent(number, getRoot());
            rotation = false;
            if (parent.getLeft() != null)
                if (parent.getLeft().getNumber() == number) {
                    rotationRight(parent);
                    rotation = true;
                }
            if (parent.getRight() != null && !rotation)
                if (parent.getRight().getNumber() == number) {
                    rotationLeft(parent);
                }
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
