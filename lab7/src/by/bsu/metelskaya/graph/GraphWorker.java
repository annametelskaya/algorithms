package by.bsu.metelskaya.graph;

public class GraphWorker {
    public static void printGraph(Graph graph) {
        if (graph.getVertexNumber() == 0) {
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
}
