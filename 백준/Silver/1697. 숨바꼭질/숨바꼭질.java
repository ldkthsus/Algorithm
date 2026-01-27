import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, cnt;
    public static int di[] = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;
        if(n == m){
            System.out.println(0);
            return;
        }
        bfs(n);
        System.out.println(cnt);
    }

    public static void bfs(int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[100001];
        queue.offer(i);
        visited[i] = true;
        naga:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int now = queue.poll();
                for (int d = 0; d < 3; d++) {
                    int ni = now + di[d];
                    if (di[d] == 2) {
                        ni = now * 2;
                    }

                    if (ni < 0 || ni > 100000 || visited[ni])
                        continue;
                    if (ni == m) {
                        cnt++;
                        break naga;
                    }
                    queue.offer(ni);
                    visited[ni] = true;
                }
            }
            cnt++;
        }
    }
}