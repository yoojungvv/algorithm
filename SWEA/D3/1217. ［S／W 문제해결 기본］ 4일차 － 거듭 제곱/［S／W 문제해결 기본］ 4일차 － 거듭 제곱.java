import java.util.Scanner;
public class Solution {

    public static int by(int N, int M) {
        if(M==0) {
            return 1;
        } else {
            return N * by(N, M-1);
        }
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int tc = 0;
    while(tc<=10) {
        tc = sc.nextInt();

        int N =  sc.nextInt();
        int M =  sc.nextInt();

        int result = by(N, M);

        System.out.println("#"+tc+" "+result);
        tc++;
    }

    }
}
