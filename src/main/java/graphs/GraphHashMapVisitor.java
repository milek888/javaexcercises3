package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://codereview.stackexchange.com/questions/48518/depth-first-search-breadth-first-search-implementation/48530
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
public class GraphHashMapVisitor {
    private HashMap<Node, LinkedList<Node>> adjacency;

    public GraphHashMapVisitor() {
        this.adjacency = new HashMap<>();
    }

    public void addEdge(Node source, Node target) {
        LinkedList<Node> nodes = adjacency.computeIfAbsent(source, k -> new LinkedList<>());
        nodes.add(target);
    }

    private HashMap<Node, Boolean> initVisitedMap() {
        HashMap<Node, Boolean> visited = new HashMap<>();
        for (Node node : adjacency.keySet()) {
            visited.put(node, false);
        }
        return visited;
    }

    public List<Node> runDfs(Node v) {
        HashMap<Node, Boolean> visited = initVisitedMap();
        List<Node> visitedPath = new ArrayList<>();
        dfs(v, visited, visitedPath);//TODO how to do it more functionally not to modify input param visitedPath
        return visitedPath;
    }

    private void dfs(Node v, HashMap<Node, Boolean> visited, List<Node> visitedPath) {
        visited.put(v, true);

        double result = v.accept(NodeVisitor1.getNodeVisitor1());
        System.out.print(" " + result + " ");
        visitedPath.add(v);

        for (Node w : adjacency.get(v)) {
            if (!visited.get(w)) {
                dfs(w, visited, visitedPath);
            }
        }
    }

    public List<Node> bfs(Node start) {
        HashMap<Node, Boolean> visited = initVisitedMap();
        Queue<Node> vertexQueue = new LinkedList<Node>();
        List<Node> visitedPath = new ArrayList<>();

        visited.put(start, true);
        vertexQueue.offer(start);

        while (!vertexQueue.isEmpty()) {
            Node v = vertexQueue.poll();

            double result = v.accept(NodeVisitor1.getNodeVisitor1());
            System.out.print(" " + result + " ");
            visitedPath.add(v);

            for (Node w : adjacency.get(v)) {
                if (!visited.get(w)) {
                    visited.put(w, true);
                    vertexQueue.offer(w);
                }
            }
        }
        return visitedPath;
    }

}
