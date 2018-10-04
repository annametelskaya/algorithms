package bsu.mmf.algorithms.lab2b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(null);
        Node node = null;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            node = new Node((int)(5+Math.random()*10));
            tree.insert(node, tree.getRoot());
        }
        System.out.println("Tree:\n"+tree);
        System.out.println("Enter a number for insertion into root: ");
        tree.insertIntoRoot(Integer.parseInt(scanner.nextLine()), tree.getRoot());
        System.out.println(tree);

    }
}

