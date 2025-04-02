import java.util.*;

public class Main {

    static int[][] bat;
    static boolean[][] visited;
    static int N, M;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1}; //상하좌우

    static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] next = q.poll();
            for(int i=0; i<4; i++) {
                int nr = next[0]+dr[i];
                int nc = next[1]+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && bat[nr][nc] == 1 && !visited[nr][nc]) {
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }

            }
        }



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while(T>0) {

            String[] input1 = sc.nextLine().split(" ");
            M = Integer.parseInt(input1[0]);
            N = Integer.parseInt(input1[1]);
            int K = Integer.parseInt(input1[2]);

            bat = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<K; i++) {
                String[] input2 = sc.nextLine().split(" ");
                int r = Integer.parseInt(input2[1]);
                int c = Integer.parseInt(input2[0]);
                bat[r][c] = 1;
            }

            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++){
                    if(bat[i][j]==1 && !visited[i][j]) {
                        bfs(new int[] {i, j});
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

            T--;
        }

    }
}
