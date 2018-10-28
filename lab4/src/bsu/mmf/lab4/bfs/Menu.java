package bsu.mmf.lab4.bfs;

import bsu.mmf.lab4.Graph;
import bsu.mmf.lab4.euleriancycle.Algorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {
    static void GetMenu() {
        int v = 5;
        Graph graph = new Graph(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect: " +
                    "\n1)Print graph" +
                    "\n2)Add vertex" +
                    "\n3)Add edge" +
                    "\n4)Delete vertex" +
                    "\n5)Delete edge" +
                    "\n6)BFS" +
                    "\n7)Exit");
            int num = getNumber();
            switch (num) {
                case 1: {
                    graph.printGraph();
                    break;
                }
                case 2: {
                    graph.addVertex();
                    break;
                }
                case 3: {
                    System.out.println("enter vertices of new edge: ");
                    int n1 = (getNumber() - 1);
                    int n2 = (getNumber() - 1);
                    graph.addEdge(n1, n2);
                    break;
                }
                case 4: {
                    System.out.println("Choose vertex from 1 to " + graph.getVertexNumber() + ":");
                    int n = (getNumber() - 1);
                    graph.removeVertex(n);
                    break;
                }
                case 5: {
                    System.out.println("enter vertices of edge:");
                    int n1 = (getNumber() - 1);
                    int n2 = (getNumber() - 1);
                    graph.removeEdge(n1, n2);
                    break;
                }
                case 6: {
                    BFS.find(graph);
                    break;
                }
                case 7: {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("choose 1-");
                }
            }
        }
    }

    private static int getNumber() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (true) {
            try {
                n = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("not a number");
                break;
            }
        }
        return n;
    }
}
