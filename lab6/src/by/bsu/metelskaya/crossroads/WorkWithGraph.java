package by.bsu.metelskaya.crossroads;

class WorkWithGraph {

    static int[][] convertToMatrix(Graph graph) {
        int vertexNumber = graph.getVertexNumber();
        int[][] matrix = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                matrix[i][j] = 9999;
            }
        }
        for (int i = 0; i < vertexNumber; i++) {
                matrix[i][i] = 0;
        }
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < graph.getAdjacencyList()[i].size(); j++) {
                matrix[i][graph.getAdjacencyList()[i].get(j).getVertex()] = graph.getAdjacencyList()[i].get(j).getWeight();
            }
        }
        return matrix;
    }

    static void printGraph(Graph graph) {
        if (graph.getVertexNumber() == 0) {
            System.out.println("Enter graph");
            return;
        }
        System.out.println("Adjacency List:  ");
        for (int v = 0; v < graph.getVertexNumber(); v++) {
            System.out.print("vertex " + (v + 1));
            for (Node connected : graph.getAdjacencyList()[v]) {
                System.out.print(" -> " + connected);
            }
            System.out.println();
        }
    }
}