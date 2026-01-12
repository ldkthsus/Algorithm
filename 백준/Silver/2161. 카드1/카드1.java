import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        if (queue.size() == 1) {
            System.out.println(queue.poll());
        } else {
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append(queue.poll()).append(" ");
                if (queue.size() == 1) {
                    sb.append(queue.poll()).append(" ");
                    break;
                }
                int num = queue.poll();
                queue.offer(num);
            }
            System.out.println(sb);
        }
    }
}