import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = Integer.parseInt(sc.nextLine());
        int N = Integer.parseInt(sc.nextLine());

        int maxCake = 0;
        int maxP = 0;
        int[] roll = new int[L+1];
        for(int i=1; i<=N; i++) {
            String[] input = sc.nextLine().split(" ");
            int P = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            if(maxCake!=K-P+1) {
                maxCake = Math.max(maxCake, K-P+1);
                if(maxCake==K-P+1) maxP = i;
            }
            for(int j=P; j<=K; j++) {
                if(roll[j]==0) roll[j]=i;
            }
        }



        int[] cnt = new int[N+1];
        for(int k=1; k<=L; k++) {
            cnt[roll[k]]++;
        }
        int maxC = 0;
        int maxCP = 0;
        for(int k=1; k<=N; k++) {
            if(cnt[k]>maxC) {
                maxC = cnt[k];
                maxCP = k;
            }
        }

        System.out.println(maxP);
        System.out.println(maxCP);
    }
}