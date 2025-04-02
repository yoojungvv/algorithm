import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> computers;
    static boolean[] visited;
    static int cnt;

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int n : computers.get(curr)) {
                if(!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                    cnt++;
                }
            }

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());

        computers = new ArrayList<>();
        visited = new boolean[N+1];
        cnt = 0;

        for(int i=0; i<N+1; i++) {
            computers.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            computers.get(u).add(v);
            computers.get(v).add(u);
        }

        bfs(1);
        System.out.println(cnt);

    }
}
