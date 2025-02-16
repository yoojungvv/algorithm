import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int testCase = 1;

        while(testCase<=T) {
              String[] nk = sc.nextLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        int[][] words = new int[N+2][N+2]; //상하좌우 0 둘러줌줌
        for(int i=1; i<N+1; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j=1; j<N+1; j++) {
                words[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        int wordCnt = 0;
        //가로
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<=N-K+1; j++) {
                boolean wordAcc = true;
                for (int n=0; n<K; n++) {
                    if (words[i][j+n]!=1) {
                        wordAcc = false;
                        break;
                    } 
                }
                if(wordAcc&&words[i][j-1]!=1&&words[i][j+K]!=1) wordCnt++;
            }
        }
        //세로
        for(int j=1; j<N+1; j++) {
            for(int i=1; i<=N-K+1; i++) {
                boolean wordAcc = true;
                for (int n=0; n<K; n++) {
                    if (words[i+n][j]!=1) {
                        wordAcc = false;
                        break;
                    } 
                }
                if(wordAcc&&words[i-1][j]!=1&&words[i+K][j]!=1) wordCnt++;
            }
        }

        System.out.println("#"+testCase+" "+wordCnt);
            
        testCase++;
        }
      
    }
}