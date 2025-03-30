import java.util.*;

public class Solution {
	
	static int N, X, M, max;
	static int[][] recordes;
	static int[] cage;
	static int[] res;
	
	public static void dfs(int idx, int cnt, int[] sum) {
		//종료조건
		if(idx > N) {
			for(int i=0; i<M; i++) {
				int currSum = sum[recordes[i][1]] - sum[recordes[i][0]-1];
				if(currSum != recordes[i][2]) return;
			}
			if(cnt>max) {
				max = cnt;
				for(int i=0; i<=N; i++) {
					res[i] = cage[i];
				}
			}
			return;
		}
		
		for(int i=0; i<=X; i++) {
			cage[idx] = i;
			sum[idx] = sum[idx-1] + i;
			
			dfs(idx+1, cnt+i, sum);
			
			sum[idx] = sum[idx-1];
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		int tc = 1;
		while(tc<=T) {
			String[] input1 = sc.nextLine().split(" ");	
			N = Integer.parseInt(input1[0]);
			X = Integer.parseInt(input1[1]);
			M = Integer.parseInt(input1[2]);
			
			recordes = new int[M][3];
			for(int i=0; i<M; i++) {
				String[] input2 = sc.nextLine().split(" ");
				recordes[i][0] = Integer.parseInt(input2[0]);
				recordes[i][1] = Integer.parseInt(input2[1]);
				recordes[i][2] = Integer.parseInt(input2[2]);
			}
			
			int[] sum = new int[N+1];
			cage = new int[N+1];
			res = new int[N+1];
			max = -1;
			dfs(1, 0, sum);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			if(max == -1) {
				sb.append(" ").append(-1);
			} else {
				for(int i=1; i<res.length; i++) {
					sb.append(" ").append(res[i]);
				}
			}
			
			System.out.println(sb);
			tc++;
		}
		
		
		
	}
}
