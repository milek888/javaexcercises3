package graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class GraphHashMapVisitorTest {

    private GraphHashMapVisitor graphHashMapVisitor;

    @BeforeEach
    void setUp() {
        graphHashMapVisitor = initGraph();
    }

    @Test
    void addEdge() {
    }

    @Test
    void dfs() {
        List<Node> visitedPath = graphHashMapVisitor.runDfs(new Node(2, "Kasia"));

        List<Integer> actualVisitedLabels = visitedPath.stream()
                .map(Node::getLabel)
                .collect(toList());

        List<Integer> expectedVisitedLabels = List.of(2,0,1,3);
        assertIterableEquals(actualVisitedLabels, expectedVisitedLabels);
    }

    @Test
    void bfs() {
        List<Node> visitedPath = graphHashMapVisitor.bfs(new Node(2, "Kasia"));
        List<Integer> actualVisitedLabels = visitedPath.stream()
                .map(Node::getLabel)
                .collect(toList());

        List<Integer> expectedVisitedLabels = List.of(2,0,3,1);
        assertIterableEquals(actualVisitedLabels, expectedVisitedLabels);
    }

    private GraphHashMapVisitor initGraph() {
        GraphHashMapVisitor graphHashMapVisitor = new GraphHashMapVisitor();
        Node node0 = new Node(0, "Milosz");
        Node node1 = new Node(1, "Agata");
        Node node2 = new Node(2, "Kasia");
        Node node3 = new Node(3, "Robert");

        graphHashMapVisitor.addEdge(node0, node1);
        graphHashMapVisitor.addEdge(node0, node2);
        graphHashMapVisitor.addEdge(node1, node2);
        graphHashMapVisitor.addEdge(node2, node0);
        graphHashMapVisitor.addEdge(node2, node3);
        graphHashMapVisitor.addEdge(node3, node3);
        return graphHashMapVisitor;
    }
}