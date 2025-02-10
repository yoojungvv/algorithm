import java.util.*;

public class Main {
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int N = Integer.parseInt(sc.nextLine());
	 
	 String[] input  = sc.nextLine().split(" ");
	 
	 List<Integer> nums = new ArrayList<>();
	 
	 for (int i=0; i<input.length; i++) {
		 nums.add(Integer.parseInt(input[i]));
	 }
	 
	 int lt = 0;
	 int rt = N-1;
	 int closest = 1999999999;
	 int closestLt = 0;
	 int closestRt = N-1;
	 while(lt<rt) {
		 if(nums.get(lt) + nums.get(rt)>0) {
			 if (Math.abs(nums.get(lt) + nums.get(rt))<Math.abs(closest)) {
				 closest = nums.get(lt) + nums.get(rt);
				 closestLt = lt;
				 closestRt = rt;
			 }
			 rt--;
		 }
		 else if(nums.get(lt) + nums.get(rt)<0) {
			 if (Math.abs(nums.get(lt) + nums.get(rt))<Math.abs(closest)) {
				 closest = nums.get(lt) + nums.get(rt);
				 closestLt = lt;
				 closestRt = rt;				 
			 }
			 lt++;
		 }
		 else if(nums.get(lt) + nums.get(rt)==0) {
			 closest = nums.get(lt) + nums.get(rt);
			 closestLt = lt;
			 closestRt = rt;				 
			 break;
		 } 
	}
	 
	System.out.print(nums.get(closestLt)+" "+nums.get(closestRt));
	
	}
}	

