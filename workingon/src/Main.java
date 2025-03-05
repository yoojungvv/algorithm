import java.util.*;
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    int tc = 1;

//    while(tc<=T) {
//        tc++;
//    }

    int N = Integer.parseInt(sc.nextLine());
    int[][] food = new int[N][N];
    for(int i=0; i<N; i++) {
        String[] input = sc.nextLine().split(" ");
        for(int j=0; j<N; j++) {
            food[i][j] = Integer.parseInt(input[j]);
        }
    }

    //식재료 두개씩 짝지어 놓기
    List<ArrayList<Integer>> list = new ArrayList<>();
    int index = 0;
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            list.add(new ArrayList<>());
            list.get(index).add(i);
            list.get(index).add(j);
            index++;
        }
    }

    //두개씩 짝지어 놓은 식재료 다시 조합
    int min = Integer.MIN_VALUE;
    for(int k=0; k<N; k++) {
        for(int l=0; l<N; l++) {
            int rA = list.get(k).get(0); //1번 식재료조합 전체 맛
            int cA = list.get(k).get(1);
            int foodA = food[rA][cA] + food[cA][rA];
            int rB = list.get(l).get(0); //2번 식재료조합 전체 맛
            int cB = list.get(l).get(1);
            int foodB = food[rB][cB] + food[cB][rB];

            int gap = Math.abs(foodA-foodB);


        }
    }








    }
}














