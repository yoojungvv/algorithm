import java.util.Scanner;

public class Solution {
    
    private int[] stack;
    private int top;
    
    public Solution(int K) {
        stack = new int[K + 1];
        top = -1;
    }
    
    public void push(int N) {
        if (isFull()) return;
        stack[++top] = N;
    }
    
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == stack.length - 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            StringBuilder sb = new StringBuilder();
            int K = sc.nextInt();
            
            Solution stack = new Solution(K);
            
            for (int i = 0; i < K; i++) {
                int N = sc.nextInt();
                if (N != 0) {
                    stack.push(N);
                } else {
                    stack.pop();
                }
            }
            
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            
            sb.append("#").append(testCase).append(" ").append(sum);
            System.out.println(sb);
        }
        sc.close();
    }
}
