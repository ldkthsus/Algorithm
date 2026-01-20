import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int arr[][], cnt;
    public static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[11][11];
        map = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                arr[i][j] = (i - 1) * 10 + j;
            }
        }
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        cnt = 0;
        bfs();
    }

    public static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[11][11];
        queue.offer(new Point(1, 1));
        visited[1][1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                int location = (now.i - 1) * 10 + now.j;

                for (int k = 1; k <= 6; k++) {
                    int next = location + k;

                    if (location > 100)
                        continue;

                    int ni = (next / 10) + 1;
                    int nj = next % 10;
                    if (nj == 0) {
                        ni = next / 10;
                        nj = 10;
                    }

                    if (visited[ni][nj])
                        continue;

                    if (arr[ni][nj] == 100) {
                        cnt++;
                        System.out.println(cnt);
                        return;
                    }

                    if (map.containsKey(next)) {
                        int val = map.get(next);

                        ni = (val / 10) + 1;
                        nj = val % 10;

                        if (nj == 0) {
                            ni = val / 10;
                            nj = 10;
                        }
                        queue.offer(new Point(ni, nj));
                        visited[ni][nj] = true;
                        continue;
                    }
                    queue.offer(new Point(ni, nj));
                    visited[ni][nj] = true;
                }
            }
            cnt++;
        }
    }

    public static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}