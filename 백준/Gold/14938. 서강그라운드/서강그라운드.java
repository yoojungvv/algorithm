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
    static List<Edge>[] map;
    static boolean[] visited;
    static int n;
    static int[] dist;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nmr = sc.nextLine().split(" ");
        n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int r = Integer.parseInt(nmr[2]);

        map = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            map[i] = new ArrayList<>();
        }

        String[] items = sc.nextLine().split(" ");
        for(int i=0; i<r; i++) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int l = Integer.parseInt(input[2]);
            //양방향
            map[a].add(new Edge(b, l));
            map[b].add(new Edge(a, l));
        }

        int maxItem = 0;
        for(int i=1; i<n+1; i++) {
            dijkstra(i);
            int sumItem = 0;
            for(int j=1; j<n+1; j++) { //items 돌면서 시작지점 포함 + m 범위 안에 들어오는 dist 가진 idx 대해서 개수 다 더해줌
                if(i==j) {
                    sumItem += Integer.parseInt(items[j-1]);
                } else {
                    if(dist[j]<=m) sumItem += Integer.parseInt(items[j-1]);
                }
            }
            if(maxItem<sumItem) maxItem = sumItem;
        }

        System.out.println(maxItem);

    }

    static void dijkstra(int start) {
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for(int i=1; i<n; i++) {
            int min = INF;
            int idx = -1;
            for(int j=1; j<n+1; j++) {
                if(!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }
            if(idx == -1) break;
            visited[idx] = true;

            for(Edge e : map[idx]) {
                if(!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
                    dist[e.to] = dist[idx] + e.cost;
                }
            }
        }

    }

}
