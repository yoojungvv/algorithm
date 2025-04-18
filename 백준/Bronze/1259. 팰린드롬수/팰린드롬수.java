import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String num = sc.nextLine();
            if(num.equals("0")) break;

            int len = num.length()/2;
            Stack<Character> st = new Stack<>();
            for(int i=0; i<len; i++) {
                st.push(num.charAt(i));
            }

            boolean palindrome = true;
            for(int i=num.length()-len; i<num.length(); i++) {
                char isPalindrome = st.pop();
                if(num.charAt(i)!=isPalindrome) {
                    palindrome = false;
                    break;
                }
            }
            if(palindrome) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}