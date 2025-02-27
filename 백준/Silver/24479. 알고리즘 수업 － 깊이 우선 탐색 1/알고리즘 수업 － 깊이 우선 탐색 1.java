//BOJ_24479_깊이우선탐색1

import java.util.*;

public class Main {

    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt = 1;

    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void dfs(int node) {
        visited[node] = cnt++;
        for(int next : graph.get(node) ) {
            if(visited[next] == 0) dfs(next);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nmr = sc.nextLine().split(" ");
        int N = Integer.parseInt(nmr[0]);
        int M = Integer.parseInt(nmr[1]);
        int R = Integer.parseInt(nmr[2]);

        visited = new int[N+1];
        graph = new ArrayList<ArrayList<Integer>>();
        for(int j=0; j<N+1; j++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            addEdge(u, v);
        }

        for(int j=1; j<=N; j++) {
            Collections.sort(graph.get(j));
        }

        dfs(R);

        for(int j=1; j<=N; j++) {
            System.out.println(visited[j]);
        }

    }
}