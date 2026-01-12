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
            while (true) {
                queue.poll();
                if (queue.size() == 1) {
                    System.out.println(queue.poll());
                    break;
                }
                int num = queue.poll();
                queue.offer(num);
            }
        }
    }
}