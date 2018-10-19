package bsu.mmf.algorithms.lab3;

public class QuadraticHashTable {
    private Node[] array;
    private int size;
    public static int MAX_INSERTION = 0;

    public QuadraticHashTable(int s) {
        array = new Node[s];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Node();
        }
        size = s;
        MAX_INSERTION = 0;
    }

    public int hashFunction(int value, int i) {
        return ((value % Variables.CONST + i * i) % size);
    }

    private void insert(int value) {
        int index, a = value ;
        for (int i = 0; i < size; i++) {
            index = hashFunction(a, i);
            if (array[index].getElement() == 0) {
                if (MAX_INSERTION < i+1) {
                    MAX_INSERTION = i+1;
                }
                array[index].setElement(value);
                array[index].setKey(index);
                return;
            }
            a = index;
        }
    }

    public void insert(int[] arr) {
        for (int j = 0; j < Variables.ARRAY_SIZE; j++) {
            insert(arr[j]);
        }

    }

    public Node search(int key) {
        if (key < size) {
            return array[key];
        }
        return null;
    }

    public void display() {
        for (int j = 0; j < size; j++) {
            System.out.print(array[j].getElement() + " ");
        }
    }
}
