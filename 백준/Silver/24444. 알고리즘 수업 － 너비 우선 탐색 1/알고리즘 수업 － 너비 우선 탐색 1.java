//BOJ_24444_너비우선탐색1

import java.util.*;

public class Main {

    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt = 1;

    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node); //넣고
        visited[node] = cnt++; //visited

        while(!queue.isEmpty()) {
            int next = queue.poll();
            for(int n : graph.get(next)) {
                if(visited[n]==0) {
                    queue.offer(n);
                    visited[n] = cnt++;
                }
            }
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

        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int j=0; j<M; j++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            addEdge(u, v);
        }

        for(int i=1; i<N+1; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for(int i=1; i<N+1; i++) {
            System.out.println(visited[i]);
        }

    }
}

