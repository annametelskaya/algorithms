package bsu.mmf.algorithms.lab3;

public class Node {

    private int element;
    private int key;

    public Node(){
        element=0;
        key=0;
    }

    public Node(int element, int key) {
        this.element = element;
        this.key = key;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
