package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphMSTPrimsAlgo {
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[1].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(3, 2, 50));
//        graph[4].add(new Edge(4, 5, -3));

    }

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void mstPrimsAlgo(ArrayList<Edge> graph[], int vertex) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.weight- b.weight);
        boolean visited[] = new boolean[vertex];
        int mstCost = 0;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                mstCost += curr.weight;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String args[]) {
        int vertex = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        addEdge(graph);
        mstPrimsAlgo(graph,vertex);
    }

}

