import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }
        int ans = 0;
        while (true) {
            if (pq.size() == 1) {
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b);
            ans += (a + b);
        }
        System.out.println(ans);
    }
}