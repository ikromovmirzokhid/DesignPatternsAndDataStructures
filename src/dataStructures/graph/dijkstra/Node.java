package dataStructures.graph.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    private Map<Node, Integer> neighbors = new HashMap<>();
    private List<Node> shortestPath = new LinkedList<>();
    private int distance = Integer.MAX_VALUE;
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbor(Node node, int weight) {
        neighbors.put(node, weight);
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public int getDistance() {
        return distance;
    }

    public void setNeighbors(Map<Node, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }
}
