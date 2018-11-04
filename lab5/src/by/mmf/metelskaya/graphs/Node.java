package by.mmf.metelskaya.graphs;

class Node {
    private int vertex;
    private int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    int getVertex() {
        return vertex;
    }

    void setVertex(int vertex) {
        this.vertex = vertex;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[v:" + (vertex + 1) + ",w:" + weight + "]";
    }
}
