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
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
            } else if (order.equals("pop")) {
                if (deque.isEmpty())
                    sb.append(-1).append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            } else if (order.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (order.equals("front")) {
                if (deque.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(deque.peekFirst()).append("\n");
            } else if (order.equals("back")) {
                if (deque.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(deque.peekLast()).append("\n");
            } else {
                if (deque.isEmpty())
                    sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}