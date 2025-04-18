import java.util.*;

public class Main {

    static int N, M;
    static int[] dr = {-1, 0, 1, 0}; //상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int cntClean;

    public static void clean(int r, int c, int d) {

        if(map[r][c]==0) {
            map[r][c]=2;
            cntClean++;
//            System.out.println("-----------------------------------");
//            System.out.println("r :"+r+" c :"+c+" d :"+d+ " cnt : "+cntClean);
        } //현재있는 칸 청소 안했으면 청소하기

        boolean flag = true;
        for(int i=3; i>=0; i--) {
            int nextD = (d+i)%4;
            int nr = r + dr[nextD];
            int nc = c + dc[nextD];
//            System.out.println("map["+nr+"]["+nc+"] = "+map[nr][nc]);
            if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc]==0) {
                flag = false;
                clean(nr, nc, nextD);
                break;
            }
        }

        if(flag) {
            int anotherD = (d+2)%4;
            int mr = r + dr[anotherD];
            int mc = c + dc[anotherD];
            if(mr<N && mr>=0 && mc<M && mc>=0 && map[mr][mc]!=1) {
                clean(mr, mc, d);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String[] NM = sc.nextLine().split(" ");
            N = Integer.parseInt(NM[0]);
            M = Integer.parseInt(NM[1]);
            String[] rcd = sc.nextLine().split(" ");
            int r = Integer.parseInt(rcd[0]);
            int c = Integer.parseInt(rcd[1]);
            int d = Integer.parseInt(rcd[2]);

            map = new int[N][M];

            for(int i=0; i<N; i++) {
                String[] input = sc.nextLine().split(" ");
                for(int j=0; j<M; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            clean(r, c, d);

            System.out.println(cntClean);
    }
}




