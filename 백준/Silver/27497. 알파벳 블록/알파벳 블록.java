import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Character> de = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() == 3) {
                if (str.charAt(0) - '0' == 1) {
                    de.offerLast(str.charAt(2));
                    list.add(1);
                } else {
                    de.offerFirst(str.charAt(2));
                    list.add(2);
                }
            } else {
                if (list.isEmpty())
                    continue;
                if (list.get(list.size() - 1) == 1) {
                    de.pollLast();
                    list.remove(list.size() - 1);
                } else {
                    de.pollFirst();
                    list.remove(list.size() - 1);
                }
            }
        }

        if (de.isEmpty())
            System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            int size = de.size();
            for (int i = 0; i < size; i++) {
                sb.append(de.pollFirst());
            }
            System.out.println(sb);
        }
    }
}