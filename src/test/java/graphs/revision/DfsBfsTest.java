package graphs.revision;

import graphs.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class DfsBfsTest {

    private DfsBfs dfsBfs;

    @BeforeEach
    void setUp() {
        dfsBfs = initGraph();
    }

    @Test
    void addEdge() {
    }

    @Test
    void dfs() {
        List<Node> visitedPath = dfsBfs.runDfs(new Node(2, "Kasia"));

        List<Integer> actualVisitedLabels = visitedPath.stream()
                .map(Node::getLabel)
                .collect(toList());

        List<Integer> expectedVisitedLabels = List.of(2,0,1,3);
        assertIterableEquals(actualVisitedLabels, expectedVisitedLabels);
    }

    @Test
    void bfs() {
        List<Node> visitedPath = dfsBfs.runBfs(new Node(2, "Kasia"));

        List<Integer> actualVisitedLabels = visitedPath.stream()
                .map(Node::getLabel)
                .collect(toList());

        List<Integer> expectedVisitedLabels = List.of(2,0,3,1);
        assertIterableEquals(actualVisitedLabels, expectedVisitedLabels);
    }

    private DfsBfs initGraph() {
        DfsBfs dfsBfs = new DfsBfs();
        Node node0 = new Node(0, "Milosz");
        Node node1 = new Node(1, "Agata");
        Node node2 = new Node(2, "Kasia");
        Node node3 = new Node(3, "Robert");

        dfsBfs.addEdge(node0, node1);
        dfsBfs.addEdge(node0, node2);
        dfsBfs.addEdge(node1, node2);
        dfsBfs.addEdge(node2, node0);
        dfsBfs.addEdge(node2, node3);
        dfsBfs.addEdge(node3, node3);
        return dfsBfs;
    }
}