package bsu.mmf.algorithms.lab2b;

public class Node {
    private int number;
    private int countNodeLeft;
    private int countNodeRight;
    private Node left;
    private Node right;

    public Node(int number) {
        this.setNumber(number);
    }

    public Node(int number, Node left, Node right) {
        this.setNumber(number);
        this.setCountNodeLeft(0);
        this.setCountNodeRight(0);
        this.setLeft(left);
        this.setRight(right);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountNodeLeft() {
        return countNodeLeft;
    }

    public void setCountNodeLeft(int countNodeLeft) {
        this.countNodeLeft = countNodeLeft;
    }

    public int getCountNodeRight() {
        return countNodeRight;
    }

    public void setCountNodeRight(int countNodeRight) {
        this.countNodeRight = countNodeRight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("value=" + number);
        if (left != null) {
            builder.append(", left=" + left);
        } else {
            builder.append(", left= no");
        }
        if (right != null) {
            builder.append(", right=" + right);
        } else {
            builder.append(", right= no");
        }
        builder.append("]");
        return builder.toString();
    }
}