package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class GraphKosarajusAlgo {
    public static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }

    static void addEdge(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topologicalSort(ArrayList<Edge>[] graph, Stack<Integer> stack, Boolean[] visited, int currnode) {
        visited[currnode]=true;
        for(int i=0;i<graph[currnode].size();i++){
            Edge e= graph[currnode].get(i);
            if(!visited[e.dest]){
                topologicalSort(graph,stack,visited,e.dest);
            }
        }
        stack.push(currnode);
    }

    static void kosarajuAlgo(ArrayList<Edge> graph[], int vertex) {
//        Step 1: toplogical sort
        Stack<Integer> stack = new Stack<>();
        Boolean[] visited = new Boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                topologicalSort(graph, stack, visited, i);
            }
        }



    }


}
