import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");

        double sum = 0;
        double M = -1;
        for(int i=0; i<N; i++) {
            double num =  Double.parseDouble(nums[i]);
            sum += num;
            M = Math.max(M, num);
        }

        double result = sum/M/N*100;
        System.out.println(result);
    }
}