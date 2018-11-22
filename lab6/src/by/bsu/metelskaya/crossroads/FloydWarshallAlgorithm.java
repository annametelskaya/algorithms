package by.bsu.metelskaya.crossroads;

import static java.lang.Math.min;

class FloydWarshallAlgorithm {

    private static int INF = 99999;

    static void floydWarshall(int[][] graph) {
        int vertexNumber = graph.length;
        int[][] distant = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            System.arraycopy(graph[i], 0, distant[i], 0, vertexNumber);
        }
        for (int k = 0; k < vertexNumber; k++)
            for (int i = 0; i < vertexNumber; i++)
                for (int j = 0; j < vertexNumber; j++)
                    distant[i][j] = min(distant[i][j], distant[i][k] + distant[k][j]);
        print(distant);
        findPlace(distant);
    }

    private static void print(int graph[][]) {
        System.out.println("shortest distances between every pair of vertices: ");
        for (int[] g : graph) {
            for (int j = 0; j < graph.length; ++j)
                System.out.print(g[j] + "   ");
            System.out.println();
        }
        System.out.println();
    }

    private static void findPlace   (int[][] graph) {
        int vertexNumber = graph.length;
        int[] eccentricity = new int[vertexNumber];
        int radius = Integer.MAX_VALUE;
        int center=0;
        for (int i = 0; i < vertexNumber; i++) {
            radius = min(radius, eccentricity[i]);
        }
        for (int i = 0; i < vertexNumber; i++) {
            if (eccentricity[i] == radius) {
                center = i+1;
            }
        }
        System.out.println("Center: "+ center);
    }
}
