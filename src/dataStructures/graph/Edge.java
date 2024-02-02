package dataStructures.graph;

public class Edge<T> {
    private Vertex<T> start;
    private Vertex<T> end;
    private Integer weight;

    public Edge(Vertex<T> start, Vertex<T> end, Integer weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vertex<T> getStart() {
        return start;
    }

    public Vertex<T> getEnd() {
        return end;
    }

    public Integer getWeight() {
        return weight;
    }
}
