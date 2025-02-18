
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int testCase = 1; 
		
		while(testCase<=T) {
			String[] nk = sc.nextLine().split(" ");
			int N = Integer.parseInt(nk[0]);
			int K = Integer.parseInt(nk[1]);
			String input = sc.nextLine();
			
			List<Character> nums = new ArrayList<>();
			for(int i=0; i<input.length(); i++)
				nums.add(input.charAt(i));
			
			int[] passwords = new int[N];
			StringBuilder sb = new StringBuilder();
			int len = N/4; //비밀번호의 길이 ex.3
			char temp = 0;
			for(int i=0; i<len; i++) {
				for(int n=1; n<=4; n++) {
					for(int j=len*(n-1); j<len*n; j++) {
						sb.append(nums.get(j));
					}//// 16->10으로 변환해서 넣기
					passwords[4*i+n-1] = Integer.parseInt(sb.toString(), 16);
					sb.setLength(0);
				}
				temp = nums.get(N-1);
				nums.add(0, temp); //길이가 N+1 됨
				nums.remove(N); //앞으로 옮겼던 맨 마지막 char 지워줌
			}
			

			Arrays.sort(passwords);	
			int orderCnt = 1;
			int result = passwords[passwords.length-1];
			for(int i=passwords.length - 2 ; i>=0; i--) {
				if (K==1) break;
				if(passwords[i]!=passwords[i+1]) {
					orderCnt++;
				} 
				if(orderCnt==K) {
					result = passwords[i];
					break;
				}

			}
			
			System.out.println("#"+testCase+" "+result);
			
		testCase++;
		}

	}	
}
