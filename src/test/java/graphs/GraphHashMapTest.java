package graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class GraphHashMapTest {//TODO refactor tests

    private GraphHashMap graphHashMap;

    @BeforeEach
    void setUp() {
         graphHashMap = initGraph();
    }

    @Test
    void addEdge() {
    }

    @Test
    void dfs() {
        List<Node> visitedPath = graphHashMap.runDfs(new Node(2, "Kasia"));

        List<Integer> actualVisitedLabels = visitedPath.stream()
                .map(Node::getLabel)
                .collect(toList());

        List<Integer> expectedVisitedLabels = List.of(2,0,1,3);
        assertIterableEquals(actualVisitedLabels, expectedVisitedLabels);
    }

    @Test
    void bfs() {
        List<Node> visitedPath = graphHashMap.bfs(new Node(2, "Kasia"));
        List<Integer> actualVisitedLabels = visitedPath.stream()
                .map(Node::getLabel)
                .collect(toList());

        List<Integer> expectedVisitedLabels = List.of(2,0,3,1);
        assertIterableEquals(actualVisitedLabels, expectedVisitedLabels);
    }

    private GraphHashMap initGraph() {
        GraphHashMap graphHashMap = new GraphHashMap();
        Node node0 = new Node(0, "Milosz");
        Node node1 = new Node(1, "Agata");
        Node node2 = new Node(2, "Kasia");
        Node node3 = new Node(3, "Robert");

        graphHashMap.addEdge(node0, node1);
        graphHashMap.addEdge(node0, node2);
        graphHashMap.addEdge(node1, node2);
        graphHashMap.addEdge(node2, node0);
        graphHashMap.addEdge(node2, node3);
        graphHashMap.addEdge(node3, node3);
        return graphHashMap;
    }
}