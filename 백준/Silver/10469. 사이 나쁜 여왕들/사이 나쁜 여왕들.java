import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int di[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int dj[] = {0, 0, -1, 1, -1, 1, -1, 1};
    public static char arr[][];
    public static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[8][8];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                char ch = str.charAt(j);
                if (ch == '*')
                    list.add(new Point(i, j));
                arr[i][j] = ch;
            }
        }
        check = true;
        if(list.size() != 8){
            System.out.println("invalid");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            bfs(list.get(i).i, list.get(i).j);
            if (!check) {
                System.out.println("invalid");
                return;
            }
        }
        System.out.println("valid");
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[8][8];
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        naga:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                for (int d = 0; d < 8; d++) {
                    int ni = now.i + di[d];
                    int nj = now.j + dj[d];

                    for (int a = 0; a < 8; a++) {
                        if (a > 0) {
                            ni = ni + di[d];
                            nj = nj + dj[d];
                        }

                        if (ni < 0 || ni >= 8 || nj < 0 || nj >= 8 || visited[ni][nj])
                            continue;
                        if (arr[ni][nj] == '*') {
                            check = false;
                            break naga;
                        }
                    }
                }
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