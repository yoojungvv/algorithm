import java.util.*;
import java.lang.*;

import static java.lang.Math.abs;

public class Main {

    static int[][] nations;
    static boolean[][] visited;
    static boolean flag;
    static int N;
    static int L;
    static int R;
    static int unionSum;
    static int unionCnt;
    static int[] dr = {-1, 1, 0, 0}; //상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> q;
    static List<int[]> union;

    public static void bfs(int r, int c) {
        q.offer(new int[] {r,c});
        union.add(new int[] {r,c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curPop = nations[curr[0]][curr[1]];
            for(int i=0; i<4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if(nr<N & nr>=0 && nc<N && nc>=0 && !visited[nr][nc]) {
                    if(abs(curPop-nations[nr][nc]) >= L && abs(curPop-nations[nr][nc]) <= R) {
                        union.add(new int[] {nr, nc});
                        q.offer(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        if(union.size()==1) {
            union.clear();
            visited[r][c] = false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input1 = sc.nextLine().split(" ");
        N = Integer.parseInt(input1[0]);
        L = Integer.parseInt(input1[1]);
        R = Integer.parseInt(input1[2]);

        nations = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String[] input2 = sc.nextLine().split(" ");
            for(int j=0; j<N; j++) {
                nations[i][j] = Integer.parseInt(input2[j]);
            }
        }

        q = new LinkedList<>();
        int dayCnt = 0;

        flag = true;
        while(flag) {
            flag = false;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) { //flag가 전혀 안바꼈으면 그만 돌고 전체 며칠 cnt  출력해
                    if(!visited[i][j]) {
                        unionCnt = 0;
                        unionSum = 0;
                        union = new ArrayList<>();
                        bfs(i, j);
                        unionCnt = union.size();
                        if(unionCnt>0) {
                            for(int[] nation : union) {
                                unionSum += nations[nation[0]][nation[1]];
                            }
                            for(int[] nation : union) {
                                nations[nation[0]][nation[1]] = unionSum/unionCnt;
                            }
                            flag = true;
                        }
                    }
                }
            }

            if(flag) dayCnt++; //한 연합이라도 인구이동이 있었으면
        }

        System.out.println(dayCnt);

    }
}
