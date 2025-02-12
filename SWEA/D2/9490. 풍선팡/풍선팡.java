
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		int testCase = 1;
		
		while(testCase<=T) {
			String[] nm = sc.nextLine().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);
			
			int[][] balloon = new int[N][M];
			for(int i=0; i<N; i++) {
				String[] input = sc.nextLine().split(" ");
				for(int j=0; j<M; j++) {
					balloon[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			//배열을 첨~끝까지 돌면서, 상하좌우 값을 더함		
			int A = 0;
			int sum = 0;
			int max = 0;
			int r = 0; 
			int c = 0; 
			int[] dr = {-1, 1, 0, 0};  //상하좌우 d
			int[] dc = {0, 0, -1, 1};
			
			// balloon[i][j]   balloon[0][0]
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					A = balloon[i][j];
					sum = A;
					for(int d=0; d<4; d++) { // 경계 벗어나지 않게 작업
						for(int a=1; a<=A; a++) { //A개 개수만큼 상하좌우로 더 터짐
							r = i+(dr[d]*a);
							c = j+(dc[d]*a);
							if(r<0||r>=N||c<0||c>=M) continue;
							sum += balloon[r][c];	
						}
					}
					if(max<sum) max = sum;

				}
			}
			
			System.out.println("#"+testCase+" "+max);
			
			testCase++;
		}	
	}
}
