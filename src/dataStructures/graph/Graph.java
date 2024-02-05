package dataStructures.graph;

import dataStructures.dynamicArray.DynamicArray;
import dataStructures.queue.Queue;

import java.util.*;

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

    public void connect(Vertex<T> start, Vertex<T> end, Integer weight) {
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

    public Iterator<T> dfsIterator() {
        DynamicArray<Vertex<T>> visited = new DynamicArray<>();
        if (vertices.size() != 0) {
            dfsTraversal(vertices.get(0), visited);
        }
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return visited.size() > i;
            }

            @Override
            public T next() {
                T data = visited.get(i).getData();
                i++;
                return data;
            }
        };
    }

    public Iterator<T> bfsIterator() {
        DynamicArray<Vertex<T>> visited = new DynamicArray<>();
        Queue<Vertex<T>> queue = new Queue<>();
        if (vertices.size() != 0) {
            visited.add(vertices.get(0));
            queue.enqueue(vertices.get(0));
        }
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                Vertex<T> start = queue.dequeue();
                for(Edge<T> e: start.getEdges()) {
                    Vertex<T> end = e.getEnd();
                    if(!visited.contains(end)) {
                        visited.add(end);
                        queue.enqueue(end);
                    }
                }
                return start.getData();
            }
        };
    }

    private void dfsTraversal(Vertex<T> start, DynamicArray<Vertex<T>> visited) {
        if (!visited.contains(start)) {
            visited.add(start);
            List<Edge<T>> edges = start.getEdges();
            for (Edge<T> edge : edges) {
                Vertex<T> end = edge.getEnd();
                dfsTraversal(end, visited);
            }
        }
    }
}
