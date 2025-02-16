import java.util.*; 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testCase = 1;

        while(testCase<=T) {
         	
        int N = sc.nextInt();
        int[][] snail = new int[N][N];
        int num =1; //채울 숫자
        int r = 0; //행 시작
        int c = -1; //열 시작
        int K = N; //각 행,열에 채울 숫자 개수
        int dir = 1; // 행, 열 증감

        while(true) {
            if(K==0) break;

            for(int i=0; i<K; i++) {
                c = c+dir;
                snail[r][c] = num++;
            }
            K--;

            for(int i=0; i<K; i++) {
                r = r+dir;
                snail[r][c] = num++;
            }
            
            dir = -dir;
        }

        System.out.println("#"+testCase);
        for(int[] row : snail) {
            System.out.println(Arrays.toString(row).replace("[","").replace("]","").replace(",",""));
        }

            
        testCase++;
        }


    }
}
