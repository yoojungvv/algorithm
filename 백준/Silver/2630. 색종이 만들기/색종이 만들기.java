import java.util.*;
public class Main {

    static boolean flag;
    static int[][] papers;
    static int standard;
    static int blue; //1
    static int white; //0

    public static void cut(int r, int c, int n) {
        //종료조건
        flag = true;
        standard = papers[r][c];
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(standard != papers[i][j]) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }

        if(flag) {
            if(standard == 1) {
                blue++;
            } else white++;
        } else { //재귀조건
            cut(r, c, n/2);
            cut(r, c+n/2, n/2);
            cut(r+n/2, c, n/2);
            cut(r+n/2, c+n/2, n/2);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        papers = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j=0; j<N; j++) {
                papers[i][j] = Integer.parseInt(input[j]);
            }
        }

        cut(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }
}