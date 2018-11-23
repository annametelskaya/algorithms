package by.bsu.metelskaya.dijkstra;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static void getMenu() {
        int v = 0;
        Graph graph = new Graph(v);
        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect: " +
                    "\n1)Print graph" +
                    "\n2)Add vertices" +
                    "\n3)Add edges" +
                    "\n4)Remove vertex" +
                    "\n5)Remove edge" +
                    "\n6)Dijkstra" +
                    "\n7)Exit");
            int num = getNumber();
            switch (num) {
                case 1: {
                    if (graph.getVertexNumber() != 0) {
                        WorkWithGraph.printGraph(graph);
                    } else {
                        System.out.println("Enter graph first");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Enter number of vertices to add: ");
                    int n = getNumber();
                    for (int i = 0; i < n; i++) {
                        graph.addVertex();
                        v++;
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter number of edges to add: ");
                    int n = getNumber();
                    for (int i = 0; i < n; i++) {
                        System.out.println("enter first vertices of " + (i + 1) + " edge: ");
                        int n1 = (getNumber() - 1);
                        System.out.println("enter second vertices of " + (i + 1) + " edge: ");
                        int n2 = (getNumber() - 1);
                        System.out.println("enter weight of " + (i + 1) + " edge: ");
                        int w = getNumber();
                        graph.addEdge(n1, n2, w);
                    }
                    break;
                }
                case 4: {
                    if (graph.getVertexNumber() == 0) {
                        System.out.println("Enter graph first");
                    } else {
                        System.out.println("Choose vertex from 1 to " + graph.getVertexNumber() + ":");
                        int n = (getNumber() - 1);
                        graph.removeVertex(n);
                    }
                    break;
                }
                case 5: {
                    if (graph.getVertexNumber() == 0) {
                        System.out.println("Enter graph first");
                    } else {
                        System.out.println("enter vertices of edge:");
                        int n1 = (getNumber() - 1);
                        int n2 = (getNumber() - 1);
                        graph.removeEdge(n1, n2);
                    }
                    break;
                }
                case 6: {
                    System.out.printf("Start vertex: ");
                    int start = getNumber()-1;
                    System.out.printf("Finish vertex: ");
                    int finish = getNumber()-1;
                    DijkstraAlgorithm.dijkstra(WorkWithGraph.convertToMatrix(graph), start,finish, graph.getVertexNumber());
                    // FloydWarshallAlgorithm.floydWarshall(WorkWithGraph.convertToMatrix(graph));
                    break;
                }
                default: {
                    System.out.println("choose 1-6");
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
