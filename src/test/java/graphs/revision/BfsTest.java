package graphs.revision;

import graphs.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BfsTest {
    Bfs bfs;

    @BeforeEach
    void addEdge() {
        bfs = initGraph();
    }


    @Test
    void bfs() {
        bfs.bfs(2);
    }

    private Bfs initGraph() {
        Bfs graph = new Bfs(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        return graph;
    }
}
