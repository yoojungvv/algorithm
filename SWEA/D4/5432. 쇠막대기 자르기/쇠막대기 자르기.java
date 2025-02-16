import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = Integer.parseInt(sc.nextLine());
        int testCase = 1;


        while(testCase<=TC) {

        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        Stack<Character> sticks = new Stack<>();
        int stickCnt = 0;

        for(int i=0; i<chars.length-1; i++) {
            if(chars[i]=='(' && chars[i+1]!=')') {
                sticks.push(chars[i]);
            }else if(chars[i]=='(' && chars[i+1]==')') {
                stickCnt += sticks.size();
            } else if(chars[i]==')' && chars[i+1]==')') {
                stickCnt++;
                sticks.pop();
            }
        }

        System.out.println("#"+testCase+" "+stickCnt);
       
        testCase++;
        }
    }
}