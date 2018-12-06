package by.bsu.metelskaya.algorithm;

import by.bsu.metelskaya.graph.Graph;

public class DepthFirstSearchAlgorithm {
    private Graph graph;
    private boolean used[];
    private int disc[];
    private int low[];
    private int parent[];
    private boolean articulationPoints[];
    private int time;

    public DepthFirstSearchAlgorithm(Graph graph) {
        time = 0;
        this.graph = graph;
        used = new boolean[graph.getVertexNumber()];
        disc = new int[graph.getVertexNumber()];
        low = new int[graph.getVertexNumber()];
        parent = new int[graph.getVertexNumber()];
        articulationPoints = new boolean[graph.getVertexNumber()];
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            parent[i] = -1;
            used[i] = false;
            articulationPoints[i] = false;
        }
    }

    public void findArticulationPoints() {
        for (int i = 0; i < graph.getVertexNumber(); i++)
            if (!used[i])
                searchForAP(i, used, disc, low, parent, articulationPoints);
        for (int i = 0; i < graph.getVertexNumber(); i++)
            if (articulationPoints[i])
                System.out.print(i + " ");
    }

    public boolean isBiconnected() {
        boolean flag = true;
        for (int i = 0; i < graph.getVertexNumber(); i++)
            if (!used[i])
                searchForAP(i, used, disc, low, parent, articulationPoints);
        for (boolean articulationPoint : articulationPoints)
            if (articulationPoint)
                flag = false;
        for (int i = 0; i < graph.getVertexNumber(); i++)
            if (!used[i])
                return false;
        return flag;
    }

    private void searchForAP(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        for (int v : graph.getAdjacencyList()[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                searchForAP(v, visited, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1)
                    ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }
}