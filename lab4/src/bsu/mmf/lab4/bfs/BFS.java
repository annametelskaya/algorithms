package bsu.mmf.lab4.bfs;

import bsu.mmf.lab4.Graph;

import java.util.LinkedList;

class BFS {
    private boolean[] used;
    private int[] components;
    private int numberOfComponents;

    void findComponents(Graph graph) {
        used = new boolean[graph.getVertexNumber()];
        components = new int[graph.getVertexNumber()];
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            used[i] = false;
            components[i] = 0;
        }
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            if (!used[i]) {
                numberOfComponents++;
                doBFS(graph, i);
            }
        }
        System.out.println("Number of components: " + numberOfComponents);
    }

    private void doBFS(Graph graph, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> v = new LinkedList<>();
        int maxLevel = 0;
        used[s] = true;
        components[s] = numberOfComponents;
        queue.add(s);
        v.add(s);
        graph.setVertexLevel(s, 0);
        while (queue.size() != 0) {
            s = queue.pop();
            for (int i = 0; i < graph.getAdjacencyList()[s].size(); i++) {
                if (!used[graph.getAdjacencyList()[s].get(i)]) {
                    queue.push(graph.getAdjacencyList()[s].get(i));
                    v.push(graph.getAdjacencyList()[s].get(i));
                    used[graph.getAdjacencyList()[s].get(i)] = true;
                    components[graph.getAdjacencyList()[s].get(i)] = numberOfComponents;
                    graph.setVertexLevel(graph.getAdjacencyList()[s].get(i), graph.getVertexLevel()[s] + 1);
                    if (maxLevel < (graph.getVertexLevel()[graph.getAdjacencyList()[s].get(i)] + 1)) {
                        maxLevel = graph.getVertexLevel()[graph.getAdjacencyList()[s].get(i)] + 1;
                    }
                }
            }
        }
        System.out.println("Component number" + numberOfComponents);
        printBFS(maxLevel, graph, v);
    }

    private void printBFS(int maxLevel, Graph graph, LinkedList<Integer> v) {

        for (int i = 0; i < maxLevel; i++) {
            System.out.print("Level " + (i + 1) + ": ");
            for (int j = 0; j < v.size(); j++) {
                if (graph.getVertexLevel()[v.get(j)] == i) {
                    System.out.print((v.get(j) + 1) + "  ");
                }
            }
            System.out.println();
        }
    }
}
