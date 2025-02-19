import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testCase = 1;
        while(testCase<=T) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.print("#"+testCase);
            if(M<=N) {
                int temp = M;
                M = N;
                N = temp;
            }
            for(int i=N+1; i<=M+1; i++) System.out.print(" "+i);
            System.out.println();

            testCase++;
        }
    }
}
