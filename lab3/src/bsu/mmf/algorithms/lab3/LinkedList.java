package bsu.mmf.algorithms.lab3;

public class LinkedList {
    private int element;
    private LinkedList next;


    public LinkedList(int value) {
        element = value;
        next = null;
    }

    public int getElement() {
        return element;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return element+"";
    }
}
