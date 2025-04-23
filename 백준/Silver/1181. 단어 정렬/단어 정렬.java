import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<String>> words = new ArrayList<>(51);
        int N = Integer.parseInt(sc.nextLine());

        for(int i=0; i<51; i++) {
            words.add(i, new ArrayList<>());
        }

        for(int i=0; i<N; i++) {
            String input =  sc.nextLine();
            int len = input.length();
            if(!words.get(len).contains(input)) words.get(len).add(input);
        }

        for(int i=1; i<51; i++) {
            Collections.sort(words.get(i));
            for(String word : words.get(i)) {
                System.out.println(word);
            }
        }
        
    }
}