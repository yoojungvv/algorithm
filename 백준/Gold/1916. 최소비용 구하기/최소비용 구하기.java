import java.sql.Array;
import java.util.*;

public class Main {

    static class Edge {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, M; //V, E
    static List<Edge>[] adj;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        M = Integer.parseInt(sc.nextLine());

        adj = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++) {
            String[] input = sc.nextLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            adj[s].add(new Edge(e, cost));
        }

        String[] startEnd = sc.nextLine().split(" ");
        int start = Integer.parseInt(startEnd[0]);
        int end = Integer.parseInt(startEnd[1]);

        visited = new boolean[N+1];
        System.out.println(dijkstra(start, end));

    }

    static int dijkstra(int start, int end) {
        dist[start] = 0;
        for(int i=1; i<N; i++) {
            int min = INF;
            int idx = -1;
            for(int j=1; j<=N; j++){
                if(!visited[j] && dist[j]<min) {
                    min = dist[j];
                    idx = j;
                }
            }
            if(idx == -1) break;
            visited[idx] = true;

            for(Edge e : adj[idx]) { //방문X, 나와 연결, 갱신
                if(!visited[e.to] && dist[e.to] > dist[idx]+e.cost) {
                    dist[e.to] = dist[idx] + e.cost;
                }
            }
        }

        return dist[end];
    }

}
