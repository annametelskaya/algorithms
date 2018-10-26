package bsu.mmf.lab4.euleriancycle;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
    private int vertexNumber;
    private LinkedList<Integer>[] adjacencyList;
    private List<Integer> cycle;

    public Graph(int number) {
        this.vertexNumber = number;
        adjacencyList = new LinkedList[number];
        for (int i = 0; i < number; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        cycle = new LinkedList<>();
    }

    public List<Integer> getCycle() {
        return cycle;
    }

    public void addEdge(int first, int second) {
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }

    public void addVertex() {
        vertexNumber++;
        LinkedList<Integer>[] a=adjacencyList;
        adjacencyList=new LinkedList[vertexNumber];
        for(int i=0;i<vertexNumber-1; i++){
            adjacencyList[i]=a[i];
        }
        adjacencyList[vertexNumber - 1] = new LinkedList<>();
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
        for (int i = v; i < vertexNumber - 1; i++) {
            adjacencyList[i] = adjacencyList[i + 1];
        }
        vertexNumber--;
    }

    public void printGraph() {
        System.out.println("Adjacency List:  ");
        for (int v = 0; v < vertexNumber; v++) {
            System.out.print("vertex " + (v + 1));
            for (int connected : adjacencyList[v]) {
                System.out.print(" -> " + (connected + 1));
            }
            System.out.println();
        }
    }

    public boolean isEulerian() {
        for (int i = 0; i < vertexNumber; i++) {
            if (!(adjacencyList[i].size() % 2 == 0)) {
                return false;
            }
        }
        return true;
    }

    public void findEulerianCycle() {
        if (!isEulerian()) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int vertex = 0;
        stack.push(vertex);
        makeCycle(stack);
    }

    private void makeCycle(Stack<Integer> stack) {
        int vertex;
        while (!stack.isEmpty()) {
            vertex = stack.peek();
            if (adjacencyList[vertex].size() > 0 && adjacencyList[adjacencyList[vertex].get(0)].size() > 0) {
                stack.push(adjacencyList[vertex].get(0));
                adjacencyList[adjacencyList[vertex].get(0)].remove(adjacencyList[adjacencyList[vertex].get(0)].indexOf(vertex));
                adjacencyList[vertex].remove(0);
            } else {
                if (adjacencyList[vertex].size() == 0) {
                    cycle.add(stack.pop() + 1);
                } else if (adjacencyList[adjacencyList[vertex].get(0)].size() == 0) {
                    cycle.add(stack.pop() + 1);
                }
            }
        }
    }
}