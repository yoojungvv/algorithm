import java.util.*;
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int cnt = 0;
    for(int i=1; i<N; i++) {
        for(int j=i+1; j<=N; j++) {
            cnt++;
        }
    }
    System.out.println(cnt*2);
    }
}