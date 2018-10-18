package bsu.mmf.algorithms.lab3;

public class Chain {
    private LinkedList first;
    private LinkedList last;
    private int len;

    public Chain() {
        first = null;
        last = null;
        len = 0;
    }

    public int getLen() {
        return len;
    }

    public void insert(int value) {
        len++;
        LinkedList temp = new LinkedList(value);
        if (first == null) {
            first = temp;
            last = temp;
        } else {
            last.setNext(temp);
            last = temp;
        }
    }

    public LinkedList find(int value) {
        LinkedList current = first;
        while (current.getElement() != value) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current;
    }

    public void delete(int value) {
        LinkedList current = first;
        LinkedList previous = first;
        if (find(value) != null) {
            while (current != null && value != current.getElement()) {
                previous = current;
                current = current.getNext();
            }
            if (previous == null) {
                first = first.getNext();
            } else {
                previous.setNext(current.getNext());
            }
        }
    }

    public void display() {
        System.out.print("Length: " + len + " chain: ");
        LinkedList current = first;
        while (current != null) {
            System.out.print(current + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
