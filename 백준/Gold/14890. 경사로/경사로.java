import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] NL = sc.nextLine().split(" ");
        N = Integer.parseInt(NL[0]);
        L = Integer.parseInt(NL[1]);
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        lamped = new boolean[N][N];
//        행탐색
        for(int i=0; i<N; i++) {
            if(lampR(i)) cnt++;
        }
        lamped = new boolean[N][N];
//        열탐색
        for(int i=0; i<N; i++) {
            if(lampC(i)) cnt++;
        }
        System.out.println(cnt);
    }


    static int N;
    static int L; //경사로 길이
    static int h;
    static int[][] map;//현재 기준 높이
    static boolean[][] lamped; //이미 경사로 깔린 길

    public static boolean lampR (int r) {
        int pt=0;
        while(pt<N-1) {
            h = map[r][pt]; //포인터에 따라 기준높이 갱신
            if(map[r][pt+1]==h) { //다음꺼가 기준높이와 같음
                pt++;
            } else if (map[r][pt+1]==h-1) { //다음꺼가 기준높이보다 1작음
                for(int i=1; i<=L; i++) {
                    if( pt+i>N-1 || lamped[r][pt+i] ||map[r][pt+i]!=h-1) return false;
                }
                for(int i=1; i<=L; i++) {
                    lamped[r][pt+i] = true;
                }
                pt += L;
            } else if (map[r][pt+1]==h+1) { //다음꺼가 기준높이보다 1큼
                for(int j=0; j<L; j++) {
                    if(pt-j<0 || lamped[r][pt-j] || map[r][pt-j]!=h) return false;
                }
                for(int j=0; j<L; j++) {
                    lamped[r][pt-j] = true;
                }
                pt++;
            } else return false;
        }
        return true;
    }

    public static boolean lampC (int c) {
        int pt=0;
        while(pt<N-1) {
            h = map[pt][c]; //포인터에 따라 기준높이 갱신
            if(map[pt+1][c]==h) { //다음꺼가 기준높이와 같음
                pt++;
            } else if (map[pt+1][c]==h-1) { //다음꺼가 기준높이보다 1작음
                for(int i=1; i<=L; i++) {
                    if(pt+i>N-1 || lamped[pt+i][c] || map[pt+i][c]!=h-1) return false;
                }
                for(int i=1; i<=L; i++) {
                    lamped[pt+i][c] = true;
                }
                pt += L;
            } else if (map[pt+1][c]==h+1) { //다음꺼가 기준높이보다 1큼
                for(int j=0; j<L; j++) {
                    if(pt-j<0 || lamped[pt-j][c] || map[pt-j][c]!=h) return false;
                }
                for(int j=0; j<L; j++) {
                    lamped[pt-j][c] = true;
                }
                pt++;
            } else return false;
        }
        return true;
    }
}
