package dataStructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<Vertex<T>> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public Vertex<T> addVertex(T data) {
        Vertex<T> v = new Vertex<>(data);
        vertices.add(v);
        return v;
    }

    public void connect(Vertex<T> start, Vertex<T> end, int weight) {
        if (isWeighted)
            start.addEdge(end, weight);
        else start.addEdge(end, null);

        if (!isDirected) {
            if (isWeighted)
                end.addEdge(start, weight);
            else end.addEdge(start, null);
        }
    }

    public void print() {
        for (Vertex<T> vertex : vertices)
            vertex.print();
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(true, false);
        Vertex<String> v1 = graph.addVertex("Mountain View");
        Vertex<String> v2 = graph.addVertex("San Fransisco");
        graph.connect(v1, v2, 10);
        graph.print();
    }

}
