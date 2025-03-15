import java.util.*;
public class Main {

    static char[] letters;
    static char[] picked;
    static int C;
    static int L;
    static Map<Character, Integer> check;

    public static void comb(int idx, int pidx) {
        //종료조건
        if(pidx == L) {

            check = new HashMap<>();
            for(char c : picked) {
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                    check.put(c, -1);
                } else {
                    check.put(c, 1);
                }
            }
            int sum = 0;
            Set<Character> keys = check.keySet();
            for(char c : keys) {
                sum += check.get(c);
            }
            if(sum>=(L-3)*(-1)+1 && sum <= (L-3)+1) System.out.println(picked);;
            return;
        }
        if(idx == C) return;

        //재귀조건
        picked[pidx] = letters[idx];
        comb(idx+1, pidx+1);

        comb(idx+1, pidx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        L = Integer.parseInt(input1[0]);
        C = Integer.parseInt(input1[1]);
        String input2 = sc.nextLine().replace(" ","");
        letters = new char[C];
        letters = input2.toCharArray();
        Arrays.sort(letters);

        picked = new char[L];
        comb(0,0);



    }
}