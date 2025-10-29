import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int r, c, sheep, wolf;
    public static String arr[][];
    public static boolean visited[][];
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int sheepCnt = 0;
        int wolfCnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && !arr[i][j].equals("#")) {
                    sheep = 0;
                    wolf = 0;
                    bfs(i, j);
                    
                    if (sheep > wolf) {
                        sheepCnt += sheep;
                    } else {
                        wolfCnt += wolf;
                    }
                }
            }
        }
        System.out.println(sheepCnt + " " + wolfCnt);
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        if (arr[i][j].equals("o")) {
            sheep++;
        } else if (arr[i][j].equals("v")) {
            wolf++;
        }
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (ni >= r || ni < 0 || nj >= c || nj < 0 || visited[ni][nj] || arr[ni][nj].equals("#"))
                    continue;

                if (arr[ni][nj].equals("o"))
                    sheep++;
                else if (arr[ni][nj].equals("v"))
                    wolf++;
                queue.offer(new Point(ni, nj));
                visited[ni][nj] = true;
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