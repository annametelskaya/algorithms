package by.bsu.metelskaya.algorithm;

import by.bsu.metelskaya.graph.Graph;

import java.util.LinkedList;

public class DFS {
    private Graph graph;
    private boolean used[];
    private int disc[];
    private int low[];
    private int parent[];
    private boolean articulationPoints[];
    private int time;

    public DFS(Graph graph) {
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

    public LinkedList<Integer> findArticulationPoints() {
        LinkedList<Integer> points = new LinkedList<>();
        for (int i = 0; i < graph.getVertexNumber(); i++)
            if (articulationPoints[i]) {
                System.out.print((i + 1) + " ");
                points.add(i);
            }
        System.out.println();
        return points;
    }

    public boolean isBiconnected() {
        boolean flag = true;
        for (int i = 0; i < graph.getVertexNumber(); i++)
            if (!used[i])
                searchForAP(i);
        for (boolean articulationPoint : articulationPoints)
            if (articulationPoint)
                flag = false;
        for (int i = 0; i < graph.getVertexNumber(); i++)
            if (!used[i])
                return false;
        return flag;
    }

    private void searchForAP(int u) {
        used[u] = true;
        disc[u] = time;
        low[u] = time;
        time++;
        int children = 0;
        for (int v : graph.getAdjacencyList()[u]) {
            if (!used[v]) {
                children++;
                parent[v] = u;
                searchForAP(v);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1)
                    articulationPoints[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    articulationPoints[u] = true;
            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }
}