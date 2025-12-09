import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int arr[], n, end, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        cnt = 0;
        bfs(start - 1);
    }

    public static void bfs(int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        boolean visited[] = new boolean[n];
        visited[i] = true;
        boolean check = false;

        naga:
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            for (int s = 0; s < size; s++) {
                int now = queue.poll();
                int jump = 0;
                while (true) {
                    jump++;
                    int ni = arr[now] * jump + now;

                    if (ni >= n)
                        break;
                    if (visited[ni])
                        continue;

                    if (ni == end - 1) {
                        check = true;
                        break naga;
                    }
                    queue.offer(ni);
                    visited[ni] = true;
                }

                jump = 0;
                while (true) {
                    jump++;
                    int nj = now - arr[now] * jump;
                    if (nj < 0)
                        break;
                    if (visited[nj])
                        continue;
                    if (nj == end - 1) {
                        check = true;
                        break naga;
                    }
                    queue.offer(nj);
                    visited[nj] = true;
                }
            }
        }
        if (check)
            System.out.println(cnt);
        else System.out.println(-1);
    }
}