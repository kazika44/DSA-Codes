package Graph;

import java.util.ArrayList;

public class GraphBellmanFord {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void addEdge(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, -1));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 3, 2));
        graph[1].add(new Edge(1, 4, 2));
//        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 2, 5));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 3, -3));
//        graph[4].add(new Edge(4, 5, -3));

    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src, int vertex) {
        int[] dist = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                    dist[v] = dist[u] + e.wt;
                }
            }
        }
        // Used to find the neagtive cycle in the graph
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                }
            }
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print(dist[i] + " ");
        }
        
    }

    public static void main(String args[]) {
        int vertex = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        addEdge(graph);
        bellmanFord(graph, 0, vertex);
    }

}

