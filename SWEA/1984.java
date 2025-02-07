import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = Integer.parseInt(sc.nextLine());
        int testCase = 1;
 
        while(testCase <= testCaseNum) {
            String[] input = sc.nextLine().split(" ");
            int sum = 0;
            int max = 0;
            int min = 10000;
            for(int i=0; i<10; i++) {
                int num = Integer.parseInt(input[i]);
                sum += num;
                if(num >= max) {
                    max = num;
                } 
                if (num <= min) {
                    min = num;
                }
            }
            sum = sum - max - min;
            int avg = (int) Math.round(sum / 8.0);
 
            System.out.println("#"+testCase+" "+ avg);
            testCase++;
        }
 
    }
}