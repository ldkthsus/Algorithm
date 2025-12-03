import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static int n, arr[][], count;
    public static Map<Integer, Integer> map;
    public static boolean choose[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[2][n];

        for (int i = 0; i < n; i++) {
            arr[0][i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[1][i] = num;
        }

        map = new HashMap<>();
        choose = new boolean[2][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            if (!choose[0][i]) {
                map.clear();
                bfs(0, i, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (int i = 0; i < n; i++) {
            if (choose[0][i])
                sb.append(arr[0][i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int i, int j, int cnt) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j, cnt));
        boolean visited[][] = new boolean[2][n];
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (!map.containsKey(arr[now.i][now.j]))
                map.put(arr[now.i][now.j], 1);
            else map.put(arr[now.i][now.j], map.get(arr[now.i][now.j]) + 1);

            int ni = (now.i + 1) % 2;
            int nj = now.j;
            int next = arr[ni][nj];

            if (!map.containsKey(next))
                map.put(next, 1);
            else map.put(next, map.get(next) + 1);

            if (arr[now.i][now.j] == next) {
                now.cnt++;
            }

            if (!visited[0][next - 1]) {
                queue.offer(new Point(0, next - 1, now.cnt + 1));
                visited[0][next - 1] = true;
            } else {
                boolean check = true;
                for (int key : map.keySet()) {
                    if (map.get(key) != 2) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int key : map.keySet()) {
                        choose[0][key - 1] = true;
                        int val = arr[1][key - 1];
                        choose[0][val - 1] = true;
                        count++;
                    }
                    break;
                }
            }
        }
    }

    public static class Point {
        int i;
        int j;
        int cnt;

        public Point(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.cnt = c;
        }
    }
}