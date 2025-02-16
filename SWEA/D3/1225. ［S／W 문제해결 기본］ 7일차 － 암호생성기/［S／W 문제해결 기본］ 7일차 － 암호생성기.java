import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 1; 

        while(testCase<=10) {
        int T = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        Queue<Integer> nums = new LinkedList<>();
        for(int i=0; i<8; i++) {
            nums.offer(Integer.parseInt(input[i]));
        }

        int temp = 0;
        boolean password = true; 
        while(password) {
            for(int i=1; i<=5; i++) {
                temp = nums.poll();
                if(temp-i<=0) {
                    nums.offer(0);
                    password = false;
                    break;
                } else {
                    nums.offer(temp-i);
                }
            }
        }

        System.out.print("#"+T+" ");
        while(!nums.isEmpty()) {
            System.out.print(nums.poll()+" ");
        }
        System.out.println();
            
            
            testCase++;
        }

        

    }
}
