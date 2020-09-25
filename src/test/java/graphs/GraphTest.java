package graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {//TODO refactor tests
    Graph graph;

    @BeforeEach
    void addEdge() {
        graph = initGraph();
    }

    @Test
    void dfs() {
        graph.runDfs(2);
    }

    @Test
    void bfs() {
        graph.bfs(2);
    }

    private Graph initGraph() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        return graph;
    }
}