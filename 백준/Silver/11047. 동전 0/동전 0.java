import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] NK = sc.nextLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[] coins = new int[N];
        for(int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(sc.nextLine());
        }
        int cntCoin = 0;
        for(int i=N-1; i>=0; i--) {
            if(K>=coins[i]) {
                cntCoin += K / coins[i];
                K = K % coins[i];
            }
//            System.out.println("K = "+K+" coins[i] = "+coins[i]+" cntCoin = "+cntCoin);
            if(K==0) break;
        }
        System.out.println(cntCoin);
    }
}