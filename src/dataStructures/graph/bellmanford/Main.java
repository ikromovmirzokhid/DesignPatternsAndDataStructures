package dataStructures.graph.bellmanford;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2, 4)));

        edges.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4, 5)));

        edges.add(new ArrayList<>(Arrays.asList(2, 3, 2)));

        edges.add(new ArrayList<>(Arrays.asList(3, 4, 1)));
        edges.add(new ArrayList<>(Arrays.asList(3, 5, 4)));

        edges.add(new ArrayList<>(Arrays.asList(4, 5, 2)));

        System.out.println(Arrays.toString(shortestPath(6, edges, 0)));

    }

    private static int[] shortestPath(int n, List<List<Integer>> edges, int source) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        for(int i = 0; i < n -1; i++) {
            for(List<Integer> edge : edges) {
                int v1 = edge.get(0);
                int v2 = edge.get(1);
                int w = edge.get(2);
                if(distances[v1] != Integer.MAX_VALUE && distances[v1] + w < distances[v2])
                    distances[v2] = distances[v1] + w;
            }
        }

        for(List<Integer> edge : edges) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            int w = edge.get(2);
            if(distances[v1] != Integer.MAX_VALUE && distances[v1] + w < distances[v2])
                return new int[]{-1};
        }

        return distances;
    }
}
