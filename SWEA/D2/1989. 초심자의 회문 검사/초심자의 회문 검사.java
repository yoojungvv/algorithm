
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int testCase = 1; 
		
		while(testCase<=T) {
			
			String input = sc.nextLine();
			Stack<Character> st = new Stack<>();
			
			for(int i=0; i<input.length(); i++) {
				st.push(input.charAt(i));
			}
			
			boolean isPalindrome = true;
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i)!=st.pop()) {
					isPalindrome = false;
					break;
				}
			}
			
			if(isPalindrome) {
				System.out.println("#"+testCase+" "+"1");
			} else {
				System.out.println("#"+testCase+" "+"0");
			}
			
			testCase++;
		}
		
		
	}
}
