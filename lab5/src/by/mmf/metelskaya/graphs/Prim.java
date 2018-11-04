package by.mmf.metelskaya.graphs;

class Prim {
    private static int minIndex(int key[], boolean used[], int V) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (!used[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }

    static int[][] primsAlgorithm(int graph[][]) {
        int vertexNumber = graph.length;
        int[][] mst = new int[vertexNumber][vertexNumber];
        int key[] = new int[vertexNumber];
        boolean used[] = new boolean[vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                mst[i][j] = 0;
            }
            key[i] = Integer.MAX_VALUE;
            used[i] = false;
        }
        int parent[] = new int[vertexNumber];
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < vertexNumber - 1; count++) {
            int u = minIndex(key, used, vertexNumber);
            used[u] = true;
            for (int v = 0; v < vertexNumber; v++)
                if (graph[u][v] != 0 && !used[v] &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        for (int i = 1; i < vertexNumber; i++) {
            mst[parent[i]][i] = graph[i][parent[i]];
            mst[i][parent[i]] = graph[i][parent[i]];
        }
        return mst;
    }
}