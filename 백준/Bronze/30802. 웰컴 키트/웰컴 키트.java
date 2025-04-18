import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        String[] TP = sc.nextLine().split(" ");

        int T = Integer.parseInt(TP[0]);
        int P = Integer.parseInt(TP[1]);

        int cntT = 0;
        for(int i=0; i<6; i++) {
            int n = Integer.parseInt(input[i]);
            cntT += n/T;
            if(n%T != 0) cntT++;
        }

        int cntP = N/P;
        int oneP = N%P;

        System.out.println(cntT);
        System.out.println(cntP+" "+oneP);
    }
}














