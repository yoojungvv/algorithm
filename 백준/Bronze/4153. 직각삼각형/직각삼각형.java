import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String[] input = sc.nextLine().split(" ");
            int[] lengths = new int[3];
            boolean flag = false;
            for(int i=0; i<3; i++) {
                lengths[i] = Integer.parseInt(input[i]);
                if(lengths[i]!=0) flag= true;
            }
            if(!flag) break;

            Arrays.sort(lengths);

            if(Math.pow(lengths[2],2)==Math.pow(lengths[0],2)+Math.pow(lengths[1],2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}