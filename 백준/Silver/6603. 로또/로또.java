import java.util.*;
public class Main {

    static int[] nums;
    static int[] picked;
    static int k;

    //총 개수 k, 뽑을 개수 6
    public static void comb(int idx, int pidx) {
        if(pidx == 6) {
            for(int i=0; i<5; i++) {
                System.out.print(picked[i]+" ");
            }
            System.out.println(picked[5]);
            return;
        }
        if(idx == k) {
            return;
        }

        //뽑음
        picked[pidx] = nums[idx];
        comb(idx+1, pidx+1);

        //안뽑음
        comb(idx+1, pidx);
    }


    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
        String[] input = sc.nextLine().split(" ");
        k = Integer.parseInt(input[0]);
        if(k!=0) {
            nums = new int[input.length-1];
            for(int i=0; i<nums.length; i++) {
                nums[i] = Integer.parseInt(input[i+1]);
            }

            //총 개수 k 뽑을 개수 6
            picked = new int[6];
            comb(0, 0);
            System.out.println();
        } else break;
    }

    }
}