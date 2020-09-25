package graphs;

import java.util.LinkedList;
import java.util.Queue;

//https://codereview.stackexchange.com/questions/48518/depth-first-search-breadth-first-search-implementation/48530
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
public class Graph {
    private int verticesNum;
    private LinkedList<Integer>[] adjacency;

    public Graph(int verticesNum) {
        this.verticesNum = verticesNum;
        this.adjacency = new LinkedList[this.verticesNum];
        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacency[v].add(w);
    }

    public void runDfs(int v) {
        boolean[] visited = new boolean[verticesNum];
        dfs(v, visited);
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(" " + v + " ");

        for (int w : adjacency[v]) {
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[verticesNum];
        Queue<Integer> vertexQueue = new LinkedList<Integer>();
        visited[start] = true;
        vertexQueue.offer(start);

        while (!vertexQueue.isEmpty()) {

            int v = vertexQueue.poll();
            System.out.print(" " + v + " ");

            for (Integer w : adjacency[v]) {
                if (!visited[w]) {
                    visited[w] = true;
                    vertexQueue.offer(w);
                }
            }
        }
    }
}
