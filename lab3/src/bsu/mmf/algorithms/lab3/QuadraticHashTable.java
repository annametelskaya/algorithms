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

    public int hashFunction(int value) {
        return (int) (value % Variables.CONST * Variables.A % 1 * size);
    }

    private void insert(int value) {
        int i = 1, hash = hashFunction(value), index = hash;
        while (array[index].getElement() != 0 && array[index].getElement() != value) {
            index = (hash + i * i) % size;
            i++;
        }
        if (array[index].getElement() != value) {
            array[index].setElement(value);
            array[index].setKey(hash);
        }
        if (MAX_INSERTION < i) {
            MAX_INSERTION = i;
        }
    }

    public void insert(int[] arr) {
        for (int j = 0; j < Variables.ARRAY_SIZE; j++) {
            insert(arr[j]);
        }

    }

    public Node search(int value) {
        int i = 1, hash = hashFunction(value), index = hash;
        while (array[index].getElement() != 0 && array[index].getElement() != value) {
            index = (hash + i * i) % size;
            i++;
        }
        if (array[index].getElement() == value) {
            return array[index];
        }
        return null;
    }

    public void display() {
        for (int j = 0; j < size; j++) {
            System.out.print(array[j].getElement() + " ");
        }
    }
}