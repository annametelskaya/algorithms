package by.bsu.metelskaya.crossroads;

import static java.lang.Math.min;

class FloydWarshallAlgorithm {

    private static int INF = 99999;

    static void floydWarshall(int[][] graph) {
        int vertexNumber = graph.length;
        int[][] dist = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            System.arraycopy(graph[i], 0, dist[i], 0, vertexNumber);
        }
        for (int k = 0; k < vertexNumber; k++)
            for (int i = 0; i < vertexNumber; i++)
                for (int j = 0; j < vertexNumber; j++)
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
        printSolution(dist);
        findPlace(dist);
    }

    private static void printSolution(int graph[][]) {
        System.out.println("shortest distances between every pair of vertices: ");
        for (int[] g : graph) {
            for (int j = 0; j < graph.length; ++j)
                System.out.print(g[j] + "   ");
            System.out.println();
        }
    }

    private static void findPlace   (int[][] graph) {
        int vertexNumber = graph.length;
        int[] extr = new int[vertexNumber];
        int rad = Integer.MAX_VALUE;
        int center=0;
        for (int i = 0; i < vertexNumber; i++) {
            rad = min(rad, extr[i]);
        }

        for (int i = 0; i < vertexNumber; i++) {
            if (extr[i] == rad) {
                center = i+1;
            }
        }
        System.out.println("Center: "+ center);
    }
}
