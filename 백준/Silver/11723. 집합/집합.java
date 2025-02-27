//BOJ_11723_집합

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        int M = Integer.parseInt(sc.nextLine());

        for(int i=0; i<M; i++){
            String[] input = sc.nextLine().split(" ");
            String cmd = input[0];
            int x = 0;
            if(input.length>1) {
                x = Integer.parseInt(input[1]);
            }

            if (cmd.equals("add")) {
                if(!list.contains(x)) {
                    list.add(x);
                }
                continue;
            }
            if (cmd.equals("remove")) {
                if(list.contains(x)) {
                    list.remove((Integer)x);
                }
                continue;
            }
            if (cmd.equals("check")) {
                if(list.contains(x)) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                if(i!=M-1) sb.append("\n");
                continue;
            }
            if (cmd.equals("toggle")) {
                if(list.contains(x)) {
                    list.remove((Integer)x);
                } else {
                    list.add(x);
                }
                continue;
            }
            if (cmd.equals("all")) {
                list.clear();
                for(int j=1; j<=20; j++) {
                    list.add(j);
                }
                continue;
            }
            if (cmd.equals("empty")) {
                list.clear();
                continue;
            }
        }
        System.out.print(sb);
    }
}