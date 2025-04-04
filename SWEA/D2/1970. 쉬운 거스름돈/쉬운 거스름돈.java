import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int tc = 1;
        while (tc <= T) {
            int N = Integer.parseInt(sc.nextLine());
            int n = N/10;
            int[] dp = new int[n+1];
            int[] coins = {1, 5, 10, 50, 100, 500, 1000, 5000};
            int[][] coinCnt = new int[n+1][8];

            for(int i=1 ; i<=n; i++) {
                dp[i] = Integer.MAX_VALUE;

                for(int j=0; j<8; j++) {
                    int coin = coins[j];
                    if(i>=coin && dp[i-coin]+1 < dp[i]) {
                        dp[i] = dp[i-coin] + 1;

                        coinCnt[i] = Arrays.copyOf(coinCnt[i-coin], 8);
                        coinCnt[i][j]++;
                    }
                }
            }

            System.out.println("#"+tc);

            for(int j=7; j>=0; j--) {
                System.out.print(coinCnt[n][j]+" ");
            }
            System.out.println("");

            tc++;
        }
    }
}