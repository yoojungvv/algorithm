import java.util.*;

public class Solution {

    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxLength;

    static void dfs(int r, int c, int length, boolean flag) {
        maxLength = Math.max(maxLength, length);
        visited[r][c] = true;

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
                if(map[r][c] > map [nr][nc]) {
                    dfs(nr, nc, length+1, flag);
                } else if(!flag && (map [nr][nc] - map[r][c] + 1) <= K) {
                    int temp = map[nr][nc];
                    map[nr][nc] = map[r][c] - 1;
                    dfs(nr, nc, length + 1, true);
                    map[nr][nc] = temp; //깎은 곳 복구
                }
            }
        }
        visited[r][c] = false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int tc = 1;

        while(tc<=T) {

            String[] NK = sc.nextLine().split(" ");
            N = Integer.parseInt(NK[0]);
            K = Integer.parseInt(NK[1]);
            map = new int[N][N];
            int max = 0;
            List<int[]> bongs = new ArrayList<>();

            for(int i=0; i<N; i++) {
                String[] input = sc.nextLine().split(" ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    if(map[i][j] > max) {
                        max = map[i][j];
                        bongs.clear();
                        bongs.add(new int[] {i, j}); //최고 봉우리 기록해둠
                    } else if (map[i][j] == max) {
                        bongs.add(new int[] {i, j});
                    }
                }
            }

            maxLength = 0;
            for(int i=0; i<bongs.size(); i++) {
                visited = new boolean[N][N];
                int r = bongs.get(i)[0];
                int c = bongs.get(i)[1];
                dfs(r, c, 1, false);
            }

            System.out.println("#"+tc+" "+maxLength);

            tc++;
        }

    }
}