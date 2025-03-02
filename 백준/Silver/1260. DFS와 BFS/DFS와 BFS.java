import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sbBFS;
    static StringBuilder sbDFS;

    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int next = q.poll();
            for(int n: graph.get(next)) {
                if(!visited[n]){
                    q.offer(n);
                    visited[n] = true;
                    sbBFS.append(" ").append(n);
                }
            }
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        for(int n : graph.get(node)) {
            if(!visited[n]) {
                sbDFS.append(" ").append(n);
                dfs(n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] NMV = sc.nextLine().split(" ");
        int N = Integer.parseInt(NMV[0]);
        int M = Integer.parseInt(NMV[1]);
        int V = Integer.parseInt(NMV[2]);

        visited = new boolean[N+1];
        graph = new ArrayList<>();
        sbBFS = new StringBuilder();
        sbDFS = new StringBuilder();

        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<M+1; i++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            addEdge(u, v);
        }

        for(int i=0; i<N+1; i++) {
            Collections.sort(graph.get(i));
        }

        sbDFS.append(V);
        dfs(V);
        System.out.println(sbDFS);

        visited = new boolean[N+1];
        sbBFS.append(V);
        bfs(V);
        System.out.print(sbBFS);


    }
}