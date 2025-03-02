import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1}; //좌, 하, 우, 상
    static int[] dc = {-1, 0, 1, 0};
    static int N;
    static int cnt;

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt ++;

        for(int k=0; k<4; k++) {
            int nr = r+dr[k];
            int nc = c+dc[k];

            if(nr>=0 && nr<N && nc>=0 && nc<N) {
                if(!visited[nr][nc] && map[nr][nc]==1) {
                   dfs(nr, nc);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> group = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String input = sc.nextLine();
            for(int j=0; j<N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j]==1) {
                    cnt = 0;
                    dfs(i, j);
                    group.add(cnt);
                }
            }
        }

        Collections.sort(group);
        System.out.println(group.size());
        for(int n:group) System.out.println(n);
    }
}
