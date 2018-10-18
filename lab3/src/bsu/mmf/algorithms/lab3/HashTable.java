package bsu.mmf.algorithms.lab3;

public class HashTable {
    private Chain[] array;
    private double A;

    public HashTable(double a) {
        array = new Chain[Variables.ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Chain();
        }
        A = a;
    }

    public int hashFunction(int value) {
        return (int) (value % Variables.CONST * A % 1 * Variables.ARRAY_SIZE);
    }

    public void insert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = hashFunction(arr[i]);
            array[index].insert(arr[i]);
        }
    }

    public LinkedList find(int key) {
        int index = hashFunction(key);
        return array[index].find(key);
    }

    public void delete(int key) {
        int index = hashFunction(key);
        array[index].delete(key);
    }

    public int findMaxChain() {
        int len = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (len < array[i].getLen()) {
                    len = array[i].getLen();
                }
            }
        }
        return len;
    }

    public void display() {
        for (int j = 0; j < array.length; j++) {
            System.out.print("№" + j + ": ");
            array[j].display();
        }
    }
}
