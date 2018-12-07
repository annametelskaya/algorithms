package by.bsu.metelskaya.algorithm;

import by.bsu.metelskaya.graph.Graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class BFS {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> component;
    private LinkedHashMap<Integer,LinkedList<Integer>> components;
    private int numberOfComponents;
    private boolean[] used;

    public BFS(Graph graph) {
        used = new boolean[graph.getVertexNumber()];
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            used[i] = false;
        }
        numberOfComponents=0;
    }

    public void findComponents(Graph graph) {
        components = new LinkedHashMap<>();
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            if (!used[i]) {
                doBFS(graph, i);
                components.put(numberOfComponents,component);
                numberOfComponents++;
            }
        }
        for (int i=0; i<components.keySet().size()-1;i++){
            graph.addEdge(components.get(i).get(0),components.get(i+1).get(0));
        }
    }

    private void doBFS(Graph graph, int v) {
        queue = new LinkedList<>();
        component = new LinkedList<>();
        used[v] = true;
        queue.add(v);
        component.add(v);
        while (queue.size() != 0) {
            v = queue.pop();
            for (int i = 0; i < graph.getAdjacencyList()[v].size(); i++) {
                if (!used[graph.getAdjacencyList()[v].get(i)]) {
                    queue.add(graph.getAdjacencyList()[v].get(i));
                    component.add(graph.getAdjacencyList()[v].get(i));
                    used[graph.getAdjacencyList()[v].get(i)] = true;
                }
            }
        }
    }
}
