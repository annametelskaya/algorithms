package bsu.mmf.algorithms.lab3;

public class QuadraticHashTable {
    private int[] array;
    private int size;
    public static int MAX_INSERTION = 0;

    public QuadraticHashTable(int s) {
        array = new int[s];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        size = s;
        MAX_INSERTION=0;
    }

    public int hashFunction(int value, int i) {
        return ((value + i * i) % size);
    }

    private void insert(int value) {
        int index, a = value, maxInsertion = 0;
        for (int i = 0; i < size; i++) {
            maxInsertion++;
            index = hashFunction(a, i);
            if (array[index] == 0) {
                if (MAX_INSERTION < maxInsertion) {
                    MAX_INSERTION = maxInsertion;
                }
                array[index] = value;
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

    public String search(int value) {
        int index;
        for (int i = 0; i < array.length; i++) {
            index = hashFunction(value, i);
            if (value == array[index]) {
                return array[index] + "";
            }
        }
        return "not found";
    }

    public void display() {
        for (int j = 0; j < size; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
