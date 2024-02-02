package dataStructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private List<Edge<T>> edges;
    private T data;

    public Vertex(T data) {
        this.data = data;
        edges = new ArrayList<>();
    }

    public void addEdge(Vertex<T> end, Integer weight) {
        edges.add(new Edge<>(this, end, weight));
    }

    public boolean removeEdge(T data) {
        return edges.removeIf(edge -> edge.getEnd().getData().equals(data));
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public T getData() {
        return data;
    }

    public void print() {
        if (edges.isEmpty())
            System.out.println(data + " ----> ");

        for (Edge<T> edge : edges) {
            System.out.println(data + " ----> " + edge.getEnd().data + (edge.getWeight() != null ? "(" + edge.getWeight() + ")" : ""));
        }
    }
}
