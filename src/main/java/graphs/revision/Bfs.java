package graphs.revision;

import java.util.LinkedList;

public class Bfs {
    private int verticesNum;
    private LinkedList<Integer>[] adjacency;

    public Bfs(int verticesNum) {
        this.verticesNum = verticesNum;
        this.adjacency = new LinkedList[this.verticesNum];
        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new LinkedList<>();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[verticesNum];
        LinkedList<Integer> vertexQueue = new LinkedList<>();

        vertexQueue.offer(start);
        visited[start] = true;
        while (!vertexQueue.isEmpty()) {

            int v = vertexQueue.poll();
            System.out.println(v);

            for (Integer w : adjacency[v]) {
                if (!visited[w]) {
                    visited[w] = true;
                    vertexQueue.offer(w);
                }
            }
        }
    }

    public void addEdge(int v, int w) {
        adjacency[v].add(w);
    }
}
