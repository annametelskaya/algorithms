package by.mmf.metelskaya.graphs.primandkruskal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static void getMenu() {
        int v = 0;
        Graph graph = new Graph(v);
        Graph primGraph = new Graph(v);
        Graph kruskalGraph = new Graph(v);
        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect: " +
                    "\n1)Print graph" +
                    "\n2)Add vertices" +
                    "\n3)Add edges" +
                    "\n4)Remove vertex" +
                    "\n5)Remove edge" +
                    "\n6)Build prim's mst" +
                    "\n7)Build kruskal's mst" +
                    "\n8)Combine prim and kruskal" +
                    "\n9)Exit");
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
                    int[][] g = WorkWithGraph.convertToMatrix(graph);
                    primGraph = new Graph(g.length, WorkWithGraph.convertToList(PrimAlgorithm.findPrimMST(g)));
                    WorkWithGraph.printGraph(primGraph);
                    // int[][] prim = PrimAlgorithm.findPrimMST(g);
                    break;
                }
                case 7: {
                    int[][] g = WorkWithGraph.convertToMatrix(graph);
                    kruskalGraph = new Graph(g.length, WorkWithGraph.convertToList(KruskalAlgorithm.findKruskalMST(g)));
                    WorkWithGraph.printGraph(kruskalGraph);
                    // int[][] kruskal = KruskalAlgorithm.findKruskalMST(g);
                    break;
                }
                case 8: {
                    Graph combineGraph = WorkWithGraph.combineGraphs(primGraph, kruskalGraph);
                    WorkWithGraph.printGraph(combineGraph);
                    break;
                }
                case 9: {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("choose 1-9");
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
