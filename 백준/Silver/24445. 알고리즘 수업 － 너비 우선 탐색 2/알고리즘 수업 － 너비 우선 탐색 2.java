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
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = cnt++;

        while(!q.isEmpty()) {
            int next = q.poll();
            for(int n : graph.get(next)) {
                if(visited[n]==0) {
                    q.offer(n);
                    visited[n] = cnt++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nmr = sc.nextLine().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int r = Integer.parseInt(nmr[2]);

        visited = new int[n+1];
        graph = new ArrayList<>();

        for(int j=0; j<n+1; j++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            addEdge(u, v);
        }

        for(int j=1; j<n+1; j++) {
            Collections.sort(graph.get(j));
            Collections.reverse(graph.get(j));
        }

        bfs(r);

        for(int j=1; j<n+1; j++) {
            System.out.println(visited[j]);
        }
    }
}
