import java.util.*;

public class Main {

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] next = q.poll();
            for(int i=0; i<4; i++) {
                int nr = next[0] + dr[i];
                int nc = next[1] + dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && maze[nr][nc]==1) {
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    maze[nr][nc] = maze[next[0]][next[1]] + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1  = sc.nextLine().split(" ");
        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);

        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String input2 = sc.nextLine();
            for(int j=0; j<M; j++) {
                maze[i][j] = input2.charAt(j) - '0';
            }
        }


        bfs(new int[] {0, 0});

        System.out.println(maze[N-1][M-1]);


    }
}
