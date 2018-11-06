package by.mmf.metelskaya.graphs;

import java.util.LinkedList;

public class WorkWithGraph {
    static int[][] convertToMatrix(Graph graph) {
        int vertexNumber = graph.getVertexNumber();
        int[][] matrix = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < graph.getAdjacencyList()[i].size(); j++) {
                matrix[i][graph.getAdjacencyList()[i].get(j).getVertex()] = graph.getAdjacencyList()[i].get(j).getWeight();
            }
        }
        return matrix;
    }

    static LinkedList<Node>[] convertToList(int[][] matrix) {
        LinkedList<Node>[] adjacencyList = new LinkedList[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] != 0) {
                    adjacencyList[i].add(new Node(j, matrix[i][j]));
                }
        }
        return adjacencyList;
    }

    static void printMST(int[][] mst) {
        for (int[] a : mst) {
            for (int j = 0; j < mst.length; j++)
                System.out.print(a[j] + " ");
            System.out.println();
        }
    }

    static Graph combineGraphs(Graph primGraph, Graph kruskalGraph) {
        int[][] prim = convertToMatrix(primGraph);
        int[][] kruskal = convertToMatrix(kruskalGraph);
        int vertexNumber = prim.length;
        int[][] combine = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (prim[i][j] == 0 && kruskal[i][j] == 0) {
                    combine[i][j] = 0;
                } else {
                    if (prim[i][j] != 0)
                        combine[i][j] = prim[i][j];
                    if (kruskal[i][j] != 0)
                        combine[i][j] = kruskal[i][j];
                }
            }
        }
        Graph combineGraph = new Graph(vertexNumber, convertToList(combine));
        return combineGraph;
    }
}
