import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int testCase = 1;
		while(testCase<=10) {
			int dump = Integer.parseInt(sc.nextLine());
			
			String[] input = sc.nextLine().split(" ");
			int[] box = new int[input.length];
			for(int i=0; i<input.length; i++) {
				box[i] = Integer.parseInt(input[i]);
			}
			
			int max;
			int min;		
			while(dump>0) {
				max = 0;
				min = 100;
				int maxIdx = -1;
				int minIdx = -1;
				for (int i=0; i<box.length; i++) {
					if(box[i]>max) {
						max = box[i];
						maxIdx = i;
					}
					if(box[i]<min) {
						min = box[i];
						minIdx = i;
					}
				}
				box[maxIdx]--;
				box[minIdx]++;
				dump--;	
			}
			
			max = 0; 
			min = 100;
			for (int i=0; i<box.length; i++) {
				if(box[i]>max) {
					max = box[i];
				}
				if(box[i]<min) {
					min = box[i];
				}
			}
			System.out.println("#"+testCase+" "+ (max-min));
			testCase++;
		}
	}
}