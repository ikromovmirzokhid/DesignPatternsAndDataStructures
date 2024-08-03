package dataStructures.graph.dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNeighbor(nodeB, 2);
        nodeA.addNeighbor(nodeC, 4);

        nodeB.addNeighbor(nodeC, 3);
        nodeB.addNeighbor(nodeD, 1);
        nodeB.addNeighbor(nodeE, 5);

        nodeC.addNeighbor(nodeD, 2);

        nodeD.addNeighbor(nodeE, 1);
        nodeD.addNeighbor(nodeF, 4);

        nodeE.addNeighbor(nodeF, 2);

        shortestPath(nodeA);
        printPaths(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));
    }

    private static void printPaths(List<Node> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream().map(Node::getName).collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank() ? node.getName() + " : " + node.getDistance() : path + " -> " + node.getName() + " : " + node.getDistance()));
        });
    }

    private static void shortestPath(Node source) {
        Set<Node> explored = new HashSet<>();
        source.setDistance(0);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        pq.add(source);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            node.getNeighbors().entrySet().stream().filter(e -> !explored.contains(e.getKey())).forEach(entry -> {
                Node neighbor = entry.getKey();
                int distance = node.getDistance() + entry.getValue();
                if (distance < neighbor.getDistance()) {
                    neighbor.setDistance(distance);
                    List<Node> path = new LinkedList<>(node.getShortestPath());
                    path.add(node);
                    neighbor.setShortestPath(path);
                }
                pq.add(neighbor);
            });
            explored.add(node);
        }
    }


}
