package by.bsu.metelskaya.graph;

import java.util.LinkedList;

public class Graph {
    private int vertexNumber;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int number) {
        this.vertexNumber = number;
        adjacencyList = new LinkedList[number];
        for (int i = 0; i < number; i++)
            adjacencyList[i] = new LinkedList<>();
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void addEdge(int first, int second) {
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }

    public void addEdges(LinkedList<Integer> list) {

    }

    public void addVertex() {
        vertexNumber++;
        LinkedList<Integer>[] a = adjacencyList;
        adjacencyList = new LinkedList[vertexNumber];
        if (vertexNumber - 1 >= 0) System.arraycopy(a, 0, adjacencyList, 0, vertexNumber - 1);
        adjacencyList[vertexNumber - 1] = new LinkedList<>();
    }

    public void removeEdge(int first, int second) {
        adjacencyList[first].remove(adjacencyList[first].indexOf(second));
        adjacencyList[second].remove(adjacencyList[second].indexOf(first));
    }

    public void removeVertex(int v) {
        for (int i = 0; i < vertexNumber; i++)
            if (adjacencyList[i].indexOf(v) > -1) {
                adjacencyList[i].remove(adjacencyList[i].indexOf(v));
                adjacencyList[v].remove(adjacencyList[v].indexOf(i));
            }
        for (int i = 0; i < vertexNumber; i++)
            for (int j = 0; j < adjacencyList[i].size(); j++)
                if (adjacencyList[i].get(j) >= v)
                    adjacencyList[i].set(j, adjacencyList[i].get(j) - 1);
        if (vertexNumber - 1 - v >= 0) System.arraycopy(adjacencyList, v + 1, adjacencyList, v, vertexNumber - 1 - v);
        vertexNumber--;
    }
}
