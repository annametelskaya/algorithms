package bsu.mmf.lab4.bfs;

import bsu.mmf.lab4.Graph;

import java.util.LinkedList;

public class BFS {
    static void find(Graph graph) {
        int maxLevel = 0;
        int s = 3;
        boolean[] visited = new boolean[graph.getVertexNumber()];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        graph.setVertexLevel(s, 0);
        while (queue.size() != 0) {
            s = queue.pop();
            for (int i = 0; i < graph.getAdjacencyList()[s].size(); i++) {
                if (graph.getVertexLevel()[graph.getAdjacencyList()[s].get(i)] == -1) {
                    graph.setVertexLevel(graph.getAdjacencyList()[s].get(i), graph.getVertexLevel()[s] + 1);
                    if (maxLevel < (graph.getVertexLevel()[graph.getAdjacencyList()[s].get(i)] + 1)) {
                        maxLevel = graph.getVertexLevel()[graph.getAdjacencyList()[s].get(i)] + 1;
                    }
                    queue.push(graph.getAdjacencyList()[s].get(i));
                }
            }
        }
        for (int i = 0; i < maxLevel; i++) {
            System.out.print("Level " + (i + 1) + ": ");
            for (int j = 0; j < graph.getVertexNumber(); j++) {
                if (graph.getVertexLevel()[j] == i) {
                    System.out.print((j + 1) + "  ");
                }
            }
            System.out.println();
        }
    }
}
