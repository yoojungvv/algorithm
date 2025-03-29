import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[][] paper = new int[100][100];

        for(int i=0; i<N; i++) {
            String[] input = sc.nextLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            for(int k=r; k<r+10; k++) {
                for(int l=c; l<c+10; l++) {
                    paper[k][l] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(paper[i][j]==1) cnt++;
            }
        }

        System.out.println(cnt);

    }
}
