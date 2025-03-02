import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;

    public static void dfs(int r, int c, int height) {
        visited[r][c] = true;

        for(int k=0; k<4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr>=0&&nr<N&&nc>=0&&nc<N) {
                if(!visited[nr][nc] && map[nr][nc]>height) dfs(nr, nc, height);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;
        for(int height=0; height<=100; height++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j]>height && !visited[i][j]) {
                        dfs(i, j, height);
                        cnt++;
                    }
                }
            }
            if(max<cnt) max = cnt;
        }

        System.out.print(max);
    }
}

