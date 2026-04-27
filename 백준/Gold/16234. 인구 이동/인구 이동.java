import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, l, r, arr[][], cnt, sum, day;
    public static boolean visited[][], isChanged;
    public static int di[] = {-1, 1, 0, 0}; //상, 하, 좌, 우
    public static int dj[] = {0, 0, -1, 1};
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        day = 0;
        while (true) {
            isChanged = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        list.clear();
                        sum = 0;
                        cnt = 0;
                        bfs(i, j);
                        for (int s = 0; s < list.size(); s++) {
                            int val = list.get(s);
                            int ni = val / n;
                            int nj = val % n;
                            int result = sum / cnt;

                            arr[ni][nj] = result;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
            if (!isChanged)
                break;
            day++;
        }
        System.out.println(day);
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        sum += arr[i][j];
        cnt++;
        list.add(i * n + j);
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj] ||
                        Math.abs(arr[now.i][now.j] - arr[ni][nj]) < l || Math.abs(arr[now.i][now.j] - arr[ni][nj]) > r)
                    continue;

                isChanged = true;
                queue.offer(new Point(ni, nj));
                visited[ni][nj] = true;
                sum += arr[ni][nj];
                cnt++;
                list.add(ni * n + nj);
            }
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