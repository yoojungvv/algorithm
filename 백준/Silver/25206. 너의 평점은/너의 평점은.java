//BOJ_25206_너의평점은

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sumSub = 0;
        double sumHour = 0;
        for(int i=0; i<20; i++) {
            String[] input = sc.nextLine().split(" ");
            double hour = Double.parseDouble(input[1]);
            String lvl = input[2];
            double level = 0.0;
            if(lvl.equals("A+")) {
                level = 4.5;
            } else if (lvl.equals("A0")) {
                level = 4.0;
            } else if (lvl.equals("B+")) {
                level = 3.5;
            } else if (lvl.equals("B0")) {
                level = 3.0;
            } else if (lvl.equals("C+")) {
                level = 2.5;
            } else if (lvl.equals("C0")) {
                level = 2.0;
            } else if (lvl.equals("D+")) {
                level = 1.5;
            } else if (lvl.equals("D0")) {
                level = 1.0;
            } else {
                level = 0.0;
            }

            if(!lvl.equals("P")) {
                sumSub += hour*level;
                sumHour += hour;
            }
        }

        System.out.print(sumSub/sumHour);

    }
}