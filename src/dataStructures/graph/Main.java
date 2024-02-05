package dataStructures.graph;

import java.util.Iterator;

public class Main {
    private static Graph<Integer> graph;

    public static void main(String[] args) {
        graph = new Graph<>(false, false);
        initTestGraph();
        Iterator<Integer> dfsIterator = graph.dfsIterator();
        System.out.println("DFS Iterator");
        while(dfsIterator.hasNext())
            System.out.println(dfsIterator.next());
        System.out.println("---------------------");
        Iterator<Integer> bfsIterator = graph.bfsIterator();
        System.out.println("BFS Iterator");
        while(bfsIterator.hasNext())
            System.out.println(bfsIterator.next());
    }

    private static void initTestGraph() {
        Vertex<Integer> v1 = graph.addVertex(1);
        Vertex<Integer> v2 = graph.addVertex(2);
        Vertex<Integer> v3 = graph.addVertex(4);
        Vertex<Integer> v4 = graph.addVertex(3);
        Vertex<Integer> v5 = graph.addVertex(5);
        Vertex<Integer> v6 = graph.addVertex(6);
        graph.connect(v1, v2, null);
        graph.connect(v1, v3, null);
        graph.connect(v2, v4, null);
        graph.connect(v4, v5, null);
        graph.connect(v5, v3, null);
    }
}