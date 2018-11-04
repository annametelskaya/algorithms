package by.mmf.metelskaya.graphs;

import java.util.LinkedList;

class Graph {
    private int vertexNumber;
    private LinkedList<Node>[] adjacencyList;

    Graph(int number) {
        vertexNumber = number;
        adjacencyList = new LinkedList[number];
        for (int i = 0; i < number; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    int getVertexNumber() {
        return vertexNumber;
    }

    LinkedList<Node>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public void setAdjacencyList(LinkedList<Node>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    Node findNode(int first, int second) {
        for (Node node : getAdjacencyList()[first]) {
            if (node.getVertex() == second) {
                return node;
            }
        }
        return null;
    }

    void addEdge(int first, int second, int weight) {
        adjacencyList[first].add(new Node(second, weight));
        adjacencyList[second].add(new Node(first, weight));
    }

    void addVertex() {
        vertexNumber++;
        LinkedList<Node>[] a = adjacencyList;
        adjacencyList = new LinkedList[vertexNumber];
        if (vertexNumber - 1 >= 0) System.arraycopy(a, 0, adjacencyList, 0, vertexNumber - 1);
        adjacencyList[vertexNumber - 1] = new LinkedList<>();
    }


    void removeEdge(int first, int second) {
        Node node1 = findNode(first, second), node2 = findNode(second, first);
        if (node1 != null && node2 != null) {
            adjacencyList[first].remove(adjacencyList[first].indexOf(node1));
            adjacencyList[second].remove(adjacencyList[second].indexOf(node2));
        } else {
            System.out.println("Can't find edge");
        }
    }

    void removeVertex(int v) {
        for (int i = 0; i < vertexNumber; i++) {
            if (adjacencyList[i].indexOf(findNode(i, v)) > -1) {
                adjacencyList[i].remove(adjacencyList[i].indexOf(findNode(i, v)));
                adjacencyList[v].remove(adjacencyList[v].indexOf(findNode(v, i)));
            }
        }
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                if (adjacencyList[i].get(j).getVertex() >= v) {
                    adjacencyList[i].set(j,
                            new Node(adjacencyList[i].get(j).getVertex() - 1, adjacencyList[i].get(j).getWeight()));
                }
            }
        }
        if (vertexNumber - 1 - v >= 0) System.arraycopy(adjacencyList, v + 1, adjacencyList, v, vertexNumber - 1 - v);
        vertexNumber--;
    }

    int[][] convertToArray() {
        int[][] graph = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                graph[i][j] = 0;
            }
        }
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                graph[i][adjacencyList[i].get(j).getVertex()] = adjacencyList[i].get(j).getWeight();
            }
        }
        return graph;
    }

    void printGraph() {
        if (getVertexNumber() == 0) {
            System.out.println("Enter graph");
            return;
        }
        System.out.println("Adjacency List:  ");
        for (int v = 0; v < getVertexNumber(); v++) {
            System.out.print("vertex " + (v + 1));
            for (Node connected : getAdjacencyList()[v]) {
                System.out.print(" -> " + connected);
            }
            System.out.println();
        }
    }

}
