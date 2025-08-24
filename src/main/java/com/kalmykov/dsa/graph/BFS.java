package com.kalmykov.dsa.graph;

import java.util.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BFS {
    public static void main(String[] args) {
        // Graph (adjacency list)
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D", "E"));
        graph.put("C", List.of("F"));
        graph.put("D", new ArrayList<>());
        graph.put("E", new ArrayList<>());
        graph.put("F", new ArrayList<>());

        Set<String> path = traverse(graph, "A");// Output: A B C D E F
        log.info("BFS traversal completed: {}", Arrays.toString(path.toArray()));
    }

    public static Set<String> traverse(Map<String, List<String>> graph, String start) {
        log.info("BFS traversal starting from vertex: {}", start);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String vertex = queue.poll(); // remove from queue
            if (!visited.contains(vertex)) {
                log.info("Visit vertex {}", vertex);
                visited.add(vertex);

                for (String neighbor : graph.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }

            }
        }
        return visited;
    }
}
