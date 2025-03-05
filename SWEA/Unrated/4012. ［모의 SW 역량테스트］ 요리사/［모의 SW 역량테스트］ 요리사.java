import java.util.*;
public class Solution {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    int tc = 1;

    while(tc<=T) {
        int N = Integer.parseInt(sc.nextLine());
        int[][] food = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j=0; j<N; j++) {
                food[i][j] = Integer.parseInt(input[j]);
            }
        }

        List<ArrayList<Integer>> listA = new ArrayList<>();
        List<ArrayList<Integer>> listB = new ArrayList<>();

        int binary = 1 << N; //2^n 개, N개의 식재료가 A인지 B인지 결정
        for(int i=0; i<binary; i++) { //0000...0 ~> 1111...1 순회
            if(Integer.bitCount(i)==N/2) { //해당 수에 1이 N/2 이면
                listA.add(new ArrayList<>());
                listB.add(new ArrayList<>());
                for(int j=0; j<N; j++) {
                    if((i & (1 << j)) == 0) {
                        listA.get(listA.size()-1).add(j);
                    } else {
                        listB.get(listB.size()-1).add(j);

                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int k=0; k<listA.size(); k++) {
            int sumA = 0;
            int sumB = 0;
            for(int i=0; i<N/2-1; i++) {
                for(int j=i+1; j<N/2; j++) {
                    int rA = listA.get(k).get(i);
                    int cA = listA.get(k).get(j);
                    sumA += food[rA][cA] + food[cA][rA];
                    int rB = listB.get(k).get(i);
                    int cB = listB.get(k).get(j);
                    sumB += food[rB][cB] + food[cB][rB];
                }
            }
            int gap = Math.abs(sumA-sumB);
            min = Math.min(min, gap);
        }

        System.out.println("#"+tc+" "+min);

        tc++;
    }

    }
}
