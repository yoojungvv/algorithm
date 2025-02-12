import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 1;

		while (testCase<=10) {
			int T = Integer.parseInt(sc.nextLine());
			//사다리 2차원 배열 입력받아 채워줌, 양쪽에 0으로만 이루어진 줄 채워줌
			int [][] ladder = new int[100][102];
			for(int i=0; i<100; i++) {
				String[] input = sc.nextLine().split(" ");
				ladder[i][0] = 0;
				ladder[i][101] = 0;
				for(int j=1; j<=100; j++) {
					ladder[i][j] = Integer.parseInt(input[j-1]);
				}	
			}
			
			//도착지점 찾아서 도착지점에서 출발함
			int endJ = 0; 
			for(int j=0; j<102; j++) {
				if(ladder[99][j]==2) {
					endJ = j;
					break;				
				}
			}

			//도착지점에서 행 r-- 해나가면서 출발지로 감
			int r = 99;
			int c = endJ;

			while(r>0) {
				if (ladder[r][c-1]==1) {
					while(ladder[r][c-1]==1)
						c--;
				}else if(ladder[r][c+1]==1) {
					while(ladder[r][c+1]==1)
						c++;
				}
				r--;
			}
			
			//결과 c에서 c-1 해야 답 (0줄 추가해서)
			System.out.println("#"+T+" "+(c-1));
		
			testCase++;
		}


	}	
}

