
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static int cnt;

    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void dfs(int node) {
        Stack<Integer> st = new Stack<>();
        st.push(node);

        while(!st.isEmpty()) {
            int next = st.pop();
            if(!visited[next]) {
                cnt++;
                visited[next] = true;
            }

            for(int n : graph.get(next)) {
                if(!visited[n]) {
                    st.push(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int comNum = Integer.parseInt(sc.nextLine());
        int N = Integer.parseInt(sc.nextLine());

        visited = new boolean[comNum+1];
        graph = new ArrayList<>();
        cnt = -1;

        for(int i=0; i<comNum+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            addEdge(u, v);
        }

        dfs(1);

        System.out.print(cnt);

    }
}
