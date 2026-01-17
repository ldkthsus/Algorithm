import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, arr[][], cnt, danji;
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    danji = 0;
                    bfs(i, j);
                    cnt++;
                    list.add(danji);
                }
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        danji++;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj] || arr[ni][nj] == 0)
                    continue;

                queue.offer(new Point(ni, nj));
                visited[ni][nj] = true;
                danji++;
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