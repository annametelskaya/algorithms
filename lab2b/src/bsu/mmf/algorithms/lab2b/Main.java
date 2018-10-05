package bsu.mmf.algorithms.lab2b;

public class Main {
    public static void main(String arg[]) {
        Tree b = new Tree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        System.out.println("Original Tree : ");
        System.out.println(b);
        System.out.println("Check whether Node with value 4 exists : " + b.find(4));
        System.out.println("Check whether Node with value 4 exists : " + b.find(24));
    }
}
