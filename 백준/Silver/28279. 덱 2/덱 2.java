import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> de = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int num = Integer.parseInt(st.nextToken());
                de.offerFirst(num);
            } else if (op == 2) {
                int num = Integer.parseInt(st.nextToken());
                de.offerLast(num);
            } else if (op == 3) {
                if (de.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(de.pollFirst()).append("\n");
            } else if (op == 4) {
                if (de.isEmpty())
                    sb.append(-1).append("\n");
                else sb.append(de.pollLast()).append("\n");
            } else if (op == 5)
                sb.append(de.size()).append("\n");
            else if (op == 6) {
                if (de.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            } else if (op == 7) {
                if (de.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(de.peekFirst()).append("\n");
            } else {
                if (de.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(de.peekLast()).append("\n");
            }
        }
        System.out.println(sb);

    }
}