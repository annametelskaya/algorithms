package by.mmf.metelskaya.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Kruskal {
    static int[][] kruskalsAlgorithm(int[][] graph) {
        int vertexNumber = graph.length;
        int maxWeight = findMaxWeight(graph);
        int[][] mst = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                mst[i][j] = 0;
            }
        }
        for (int i = 1; i <= maxWeight; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if (graph[j][k] == i) {
                        mst[j][k] = i;
                        mst[k][j] = i;
                        if (isCycle(mst, mst.length)) {
                            mst[j][k] = 0;
                            mst[k][j] = 0;
                        }
                    }
                }
            }
        }
        System.out.println();
        //WorkWithGraph.printMST(mst);
        return mst;
    }

    private static int findMaxWeight(int[][] graph) {
        int maxWeight = 0;
        for (int[] aGraph : graph) {
            for (int j = 0; j < graph.length; j++) {
                if (aGraph[j] > maxWeight) {
                    maxWeight = aGraph[j];
                }
            }
        }
        return maxWeight;
    }

    private static boolean isCycle(int[][] matrix, int vertexNumber) {
        LinkedList<Node>[] graph = WorkWithGraph.convertToList(matrix);
        boolean[] used = new boolean[vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            if (!used[i]) {
                if (isCycleUtil(graph, i, used, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(LinkedList<Node>[] graph, int currVertex, boolean[] visited, int parent) {
        visited[currVertex] = true;
        for (int i = 0; i < graph[currVertex].size(); i++) {
            int vertex = graph[currVertex].get(i).getVertex();
            if (vertex != parent) {
                if (visited[vertex]) {
                    return true;
                } else {
                    if (isCycleUtil(graph, vertex, visited, currVertex)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
