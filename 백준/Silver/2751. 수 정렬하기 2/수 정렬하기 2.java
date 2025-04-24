import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> numSet = new HashSet<>();

        for(int i=0; i<N; i++) {
            numSet.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> numList = new ArrayList<>(numSet);
        Collections.sort(numList);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int num : numList) {
            bw.write(num+"\n");
        }
        bw.flush();
        bw.close();
    }
}