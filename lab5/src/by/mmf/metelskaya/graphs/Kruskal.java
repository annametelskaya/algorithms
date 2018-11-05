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
                        if (!isCyclic(mst)) {
                            mst[j][k] = 0;
                            mst[k][j] = 0;
                        }
                    }
                }
            }
        }
        System.out.println();
        WorkWithGraph.printMST(mst);
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

    private static boolean dfs(LinkedList<Integer>[] graph, int vertexNumber, boolean[] used, int[] colors, int start) {

    }

    private static boolean checkColors(int[] colors, LinkedList<Integer>[] graph, int vertexNumber) {
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                if (colors[i] == colors[graph[i].get(j)]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclic(int[][] matrix) {
        boolean b = false;
        int[] colors = new int[matrix.length];
        boolean[] used = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            colors[i] = 0;
            used[i] = false;
        }
        for (int i = 0; i < matrix.length; i++)
            if (colors[i] == 0) {
                colors[i] = 1;
                b = dfs(WorkWithGraph.convertToList(matrix), matrix.length, used, colors, i);
            }
        return b;
    }
}
