package bsu.mmf.lab4.euleriancycle;

import java.util.Stack;

public class Algorithm {

    static void printGraph(Graph graph) {
        if(graph.getVertexNumber()==0){
            System.out.println("Enter graph");
            return;
        }
        System.out.println("Adjacency List:  ");
        for (int v = 0; v < graph.getVertexNumber(); v++) {
            System.out.print("vertex " + (v + 1));
            for (int connected : graph.getAdjacencyList()[v]) {
                System.out.print(" -> " + (connected + 1));
            }
            System.out.println();
        }
    }

    static boolean isEulerian(Graph graph) {
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            if (!(graph.getAdjacencyList()[i].size() % 2 == 0)) {
                return false;
            }
        }
        return true;
    }

    static void findEulerianCycle(Graph graph) {
        if (!isEulerian(graph)) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int vertex = 0;
        stack.push(vertex);
        makeCycle(graph, stack);
    }

    private static void makeCycle(Graph graph, Stack<Integer> stack) {
        int vertex;
        while (!stack.isEmpty()) {
            vertex = stack.peek();
            if (graph.getAdjacencyList()[vertex].size() > 0 && graph.getAdjacencyList()[graph.getAdjacencyList()[vertex].get(0)].size() > 0) {
                stack.push(graph.getAdjacencyList()[vertex].get(0));
                graph.getAdjacencyList()[graph.getAdjacencyList()[vertex].get(0)].remove(graph.getAdjacencyList()[graph.getAdjacencyList()[vertex].get(0)].indexOf(vertex));
                graph.getAdjacencyList()[vertex].remove(0);
            } else {
                if (graph.getAdjacencyList()[vertex].size() == 0) {
                    graph.getCycle().add(stack.pop() + 1);
                } else if (graph.getAdjacencyList()[graph.getAdjacencyList()[vertex].get(0)].size() == 0) {
                    graph.getCycle().add(stack.pop() + 1);
                }
            }
        }
    }
}
