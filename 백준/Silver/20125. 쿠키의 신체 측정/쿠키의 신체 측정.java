import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public static int N;
    public static char arr[][];
    public static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N + 1][N + 1];
        queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j + 1] = str.charAt(j);
                if (str.charAt(j) == '*')
                    queue.offer(new Point(i, j + 1));
            }
        }
        bfs();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            boolean check = true;

            for (int d = 0; d < 4; d++) {
                int nextI = now.i + di[d];
                int nextJ = now.j + dj[d];

                if (nextI < 0 || nextI > N || nextJ < 0 || nextJ > N || arr[nextI][nextJ] == '_') {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(now.i + " " + now.j);
                int idx = 1;
                while (true) {//왼쪽 팔
                    if (now.j - idx <= 0)
                        break;
                    if (arr[now.i][now.j - idx] == '_') {
                        break;
                    }
                    idx++;
                }
                System.out.print(idx - 1 + " ");

                idx = 1;
                while (true) { //오른쪽 팔
                    if (now.j + idx > N)
                        break;
                    if (arr[now.i][now.j + idx] == '_') {
                        break;
                    }
                    idx++;
                }
                System.out.print(idx - 1 + " ");

                idx = 1;
                int midI = 0;
                int midJ = 0;
                while (true) { //허리
                    if (arr[now.i + idx][now.j] == '_') {
                        midI = now.i + idx;
                        midJ = now.j;
                        break;
                    }
                    idx++;
                }
                System.out.print(idx - 1 + " ");

                idx = 1;
                while (true) { //왼쪽 다리
                    if (midI + idx > N)
                        break;
                    if (arr[midI + idx][midJ - 1] == '_') {
                        break;
                    }
                    idx++;
                }
                System.out.print(idx+ " ");

                idx = 1;
                while (true) { //오른쪽 다리
                    if (midI + idx > N)
                        break;
                    if (arr[midI + idx][midJ + 1] == '_') {
                        break;
                    }
                    idx++;
                }
                System.out.print(idx);
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