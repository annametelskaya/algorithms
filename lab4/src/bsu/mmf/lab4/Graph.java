package bsu.mmf.lab4;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertexNumber;
    private LinkedList<Integer>[] adjacencyList;
    private List<Integer> cycle;
    private int[] vertexLevel;

    public Graph(int number) {
        this.vertexNumber = number;
        adjacencyList = new LinkedList[number];
        for (int i = 0; i < number; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        cycle = new LinkedList<>();
        vertexLevel = new int[number];
        for (int i = 0; i < vertexLevel.length; i++) {
            vertexLevel[i] = -1;
        }
    }

    public int[] getVertexLevel() {
        return vertexLevel;
    }

    public void setVertexLevel(int index, int level) {
        vertexLevel[index] = level;
    }

    public List<Integer> getCycle() {
        return cycle;
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

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public void addVertex() {
        vertexNumber++;
        LinkedList<Integer>[] a = adjacencyList;
        adjacencyList = new LinkedList[vertexNumber];
        if (vertexNumber - 1 >= 0) System.arraycopy(a, 0, adjacencyList, 0, vertexNumber - 1);
        adjacencyList[vertexNumber - 1] = new LinkedList<>();
        int[] v = vertexLevel;
        vertexLevel = new int[vertexNumber];
        if (vertexNumber - 1 >= 0) System.arraycopy(v, 0, vertexLevel, 0, vertexNumber - 1);
        vertexLevel[vertexNumber - 1] = -1;
    }

    public void removeEdge(int first, int second) {
        adjacencyList[first].remove(adjacencyList[first].indexOf(second));
        adjacencyList[second].remove(adjacencyList[second].indexOf(first));
    }

    public void removeVertex(int v) {
        for (int i = 0; i < vertexNumber; i++) {
            if (adjacencyList[i].indexOf(v) > -1) {
                adjacencyList[i].remove(adjacencyList[i].indexOf(v));
                adjacencyList[v].remove(adjacencyList[v].indexOf(i));
            }
        }
        if (vertexNumber - 1 - v >= 0) System.arraycopy(vertexLevel, v + 1, vertexLevel, v, vertexNumber - 1 - v);
        if (vertexNumber - 1 - v >= 0) System.arraycopy(adjacencyList, v + 1, adjacencyList, v, vertexNumber - 1 - v);
        vertexNumber--;
    }

    public void printGraph() {
        if (getVertexNumber() == 0) {
            System.out.println("Enter graph");
            return;
        }
        System.out.println("Adjacency List:  ");
        for (int v = 0; v < getVertexNumber(); v++) {
            System.out.print("vertex " + (v + 1));
            for (int connected : getAdjacencyList()[v]) {
                System.out.print(" -> " + (connected + 1));
            }
            System.out.println();
        }
    }

}