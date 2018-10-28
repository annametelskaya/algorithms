package bsu.mmf.lab4.euleriancycle;

import bsu.mmf.lab4.Graph;

import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {
    static void GetMenu() {
        int v = 0;
        Graph graph = new Graph(v);
        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect: " +
                    "\n1)Print graph" +
                    "\n2)Add vertex" +
                    "\n3)Add edge" +
                    "\n4)Delete vertex" +
                    "\n5)Delete edge" +
                    "\n6)Check is it possible to build cycle" +
                    "\n7)Build cycle" +
                    "\n8)Delete all vertices in graph" +
                    "\n9)Delete all edges in graph" +
                    "\n10)Exit");
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
                    if (Algorithm.isEulerian(graph)) {
                        System.out.println("Graph is eulerian");
                    } else {
                        System.out.println("Graph isn't eulerian");
                    }
                    break;
                }
                case 7: {
                    Algorithm.findEulerianCycle(graph);
                    System.out.println(graph.getCycle());
                    break;
                }
                case 8: {
                    v = 0;
                    graph = new Graph(v);
                    break;
                }
                case 9: {
                    graph = new Graph(v);
                    break;
                }
                case 10: {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("choose 1-10");
                    break;
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
