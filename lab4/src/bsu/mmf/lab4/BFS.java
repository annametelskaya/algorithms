package bsu.mmf.lab4;


import java.util.LinkedList;

class BFS {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> c;
    private int maxLevel;
    private boolean[] used;
    private int[] colors;
    private int numberOfComponents;

    BFS(Graph graph) {
        used = new boolean[graph.getVertexNumber()];
        colors = new int[graph.getVertexNumber()];
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            used[i] = false;
            colors[i] = 0;
        }
    }

    void findComponents(Graph graph) {
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            if (!used[i]) {
                numberOfComponents++;
                doBFS(graph, i);
                System.out.println("Component number" + numberOfComponents);
                printBFS(maxLevel, graph, c);
            }
        }
        System.out.println("Number of components: " + numberOfComponents);
    }

    boolean isBigraph(Graph graph) {
        doBFS(graph, 0);
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            for (int j = 0; j < graph.getAdjacencyList()[i].size(); j++) {
                if (colors[i] == colors[graph.getAdjacencyList()[i].get(j)]) {
                    return false;
                }
            }
        }
        printPartsOfBigraph(graph);
        return true;
    }

    private void printPartsOfBigraph(Graph graph) {
        System.out.println("First part of graph: ");
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            if (colors[i] == 1) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println("\nSecond part of graph: ");
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            if (colors[i] == 2) {
                System.out.print((i + 1) + " ");
            }
        }
    }

    private void doBFS(Graph graph, int v) {
        queue = new LinkedList<>();
        c = new LinkedList<>();
        maxLevel = 0;
        used[v] = true;
        queue.add(v);
        c.add(v);
        graph.setVertexLevel(v, 0);
        colors[v] = 1;
        while (queue.size() != 0) {
            v = queue.pop();
            for (int i = 0; i < graph.getAdjacencyList()[v].size(); i++) {
                if (!used[graph.getAdjacencyList()[v].get(i)]) {
                    queue.add(graph.getAdjacencyList()[v].get(i));
                    c.add(graph.getAdjacencyList()[v].get(i));
                    used[graph.getAdjacencyList()[v].get(i)] = true;
                    colors[graph.getAdjacencyList()[v].get(i)] = 3 - colors[v];
                    graph.setVertexLevel(graph.getAdjacencyList()[v].get(i), graph.getVertexLevel()[v] + 1);
                    if (maxLevel < (graph.getVertexLevel()[graph.getAdjacencyList()[v].get(i)] + 1)) {
                        maxLevel = graph.getVertexLevel()[graph.getAdjacencyList()[v].get(i)] + 1;
                    }
                }
            }
        }
    }

    private void printBFS(int maxLevel, Graph graph, LinkedList<Integer> v) {
        if (maxLevel == 0) {
            System.out.println("Level 1: " + (v.get(0) + 1));
        } else {
            for (int i = 0; i < maxLevel; i++) {
                System.out.print("Level " + (i + 1) + ": ");
                for (Integer j : v) {
                    if (graph.getVertexLevel()[j] == i) {
                        System.out.print((j + 1) + "  ");
                    }
                }
                System.out.println();
            }
        }
    }
}
