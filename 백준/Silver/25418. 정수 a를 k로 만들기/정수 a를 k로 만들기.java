import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, K, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;

        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[1000001];
        queue.offer(N);
        visited[N] = true;
        naga:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int now = queue.poll();

                int plus = now + 1;
                int multi = now * 2;

                if ((plus < 1 || plus > 1000000 || visited[plus]) &&
                        (multi < 1 || multi > 1000000 || visited[multi])) {
                    continue;
                }

                if (multi >= 1 && multi <= 1000000 && !visited[multi]) {
                    if (multi == K) {
                        ans++;
                        break naga;
                    }
                    queue.offer(multi);
                    visited[multi] = true;
                }

                if (plus >= 1 && plus <= 1000000 && !visited[plus]) {
                    if (plus == K) {
                        ans++;
                        break naga;
                    }
                    queue.offer(plus);
                    visited[plus] = true;
                }
            }
            ans++;
        }
    }
}