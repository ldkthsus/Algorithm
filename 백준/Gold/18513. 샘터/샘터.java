import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, k;
    public static long ans;
    public static int d[] = {-1, 1};
    public static Queue<Integer> queue;
    public static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = queue.poll();
            map.put(val, 1);
            queue.offer(val);
        }
        bfs();
    }

    public static void bfs() {
        int cnt = 0;
        int dis = 1;
        naga:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int now = queue.poll();

                for (int i = 0; i < 2; i++) {
                    int next = now + d[i];

                    if (!map.containsKey(next)) {
                        map.put(next, 1);
                        cnt++;
                        ans += dis;
                        queue.offer(next);
                    }
                    if (cnt == k) {
                        System.out.println(ans);
                        break naga;
                    }
                }
            }
            dis++;
        }
    }
}