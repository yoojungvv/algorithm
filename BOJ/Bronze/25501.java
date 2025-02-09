import java.util.*;

public class Main {

    public static int recursionCnt; 

    public static int recursion(String s, int l, int r) {
        recursionCnt++;
        if(l >= r) return 1; //ABBA
        else if(s.charAt(l) != s.charAt(r)) return 0; //ABC
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for(int i=0; i<T; i++) {
            recursionCnt = 0;
            String s = sc.nextLine();
            System.out.print(isPalindrome(s)+" ");
            System.out.println(recursionCnt);
            System.out.flush(); // 출력 순서가 꼬여서 마지막 입력값보다 4개 출력이 먼저 나오는 것을 처리
        }

        sc.close();
               
    }

}


// *Direct recursion (Factorial)
// public class Factorial {
//     public static int factorial(int n) {
//         if(n==0) return 1;
//         return n * factorial(n-1);
//     }
// }

// *Indirect recursion
// public class IndirectRecursion {
//     static void functionA(int n) {
//         if(n>0) {
//             System.out.println("A: "+n);
//             functionB(n-1);
//         }
//     }
//     static void functionB(int n) {
//         if(n>0) {
//             System.out.println("B: " + n);
//             functionA(n-1);
//         }

//     }

// }