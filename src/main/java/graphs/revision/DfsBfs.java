package graphs.revision;

import graphs.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class DfsBfs {
    HashMap<Node, List<Node>> adjacency;

    public DfsBfs() {
        adjacency = new HashMap<>();
    }

    public void addEdge(Node source, Node target) {
        List<Node> nodes = adjacency.computeIfAbsent(source, k -> new LinkedList<Node>());
        nodes.add(target);
    }

    /*private Map<Node, Boolean>  initVisited() {
     *//*        adjacency.keySet()
                .forEach(node -> visited.put(node, false));*//*//TODO less funcional solution
        Map<Node, Boolean> visited = adjacency.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), node -> false));//TODO better solution more functional
        return visited;
    }*/

    public List<Node> runDfs(Node node) {
        Set<Node> visited = new HashSet<>();/*initVisited()*/
        List<Node> result = new ArrayList<>();
        dfsHelper(node, visited, result);
        return result;
    }

    public void dfsHelper(Node node, Set<Node> visited, List<Node> result) {
        System.out.println(node);
        result.add(node);
        List<Node> nodes = adjacency.get(node);
        if (nodes == null) {
            return;
        }
        visited.add(node);
        for (Node childNode : nodes) {
            if (!visited.contains(childNode)) {
                dfsHelper(childNode, visited, result);
            }
        }
    }

    public List<Node> runBfs(Node root) {
        Set<Node> visited = new HashSet<>();
        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node);
            result.add(node);
            List<Node> siblings = Optional.ofNullable(adjacency.get(node))
                    .orElse(Collections.emptyList());//TODO 1) !!! dzieki temu ze zwracamy tu pusta liste zamiast null w 2) ne musimy sprawdzac czy null
            processSiblings(visited, queue, siblings);
        }

        return result;
    }

    private void processSiblings(Set<Node> visited, Queue<Node> queue, List<Node> siblings) {
       /* if (siblings != null) {*///TODO 2)
            for (Node sibling : siblings) {
                if (!visited.contains(sibling)) {
                    visited.add(sibling);
                    queue.add(sibling);
                }
            }
       /* }*/
    }

}


