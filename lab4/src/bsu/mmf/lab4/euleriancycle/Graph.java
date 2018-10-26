package bsu.mmf.lab4.euleriancycle;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Graph {
    private int vertexNumber;
    private LinkedList<Integer>[] adjacencyList;
    private List<Integer> cycle;

    Graph(int number) {
        this.vertexNumber = number;
        adjacencyList = new LinkedList[number];
        for (int i = 0; i < number; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        cycle = new LinkedList<>();
    }

    List<Integer> getCycle() {
        return cycle;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    void addEdge(int first, int second) {
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }

    void addVertex() {
        vertexNumber++;
        LinkedList<Integer>[] a = adjacencyList;
        adjacencyList = new LinkedList[vertexNumber];
        if (vertexNumber - 1 >= 0) System.arraycopy(a, 0, adjacencyList, 0, vertexNumber - 1);
        adjacencyList[vertexNumber - 1] = new LinkedList<>();
    }

    void removeEdge(int first, int second) {
        adjacencyList[first].remove(adjacencyList[first].indexOf(second));
        adjacencyList[second].remove(adjacencyList[second].indexOf(first));
    }

    void removeVertex(int v) {
        for (int i = 0; i < vertexNumber; i++) {
            if (adjacencyList[i].indexOf(v) > -1) {
                adjacencyList[i].remove(adjacencyList[i].indexOf(v));
                adjacencyList[v].remove(adjacencyList[v].indexOf(i));
            }
        }
        if (vertexNumber - 1 - v >= 0) System.arraycopy(adjacencyList, v + 1, adjacencyList, v, vertexNumber - 1 - v);
        vertexNumber--;
    }

}