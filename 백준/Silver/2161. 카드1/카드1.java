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

        Deque<Integer> de = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int last = -1;

        for (int i = 1; i <= n; i++) {
            de.offerLast(i);
        }

        while (true) {
            if (de.size() == 1) {
                last = de.pollLast();
                break;
            }
            int num = de.pollFirst();
            list.add(num);

            int val = de.pollFirst();
            de.offerLast(val);
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i)).append(" ");
        }
        sb.append(last);
        System.out.println(sb);
    }
}