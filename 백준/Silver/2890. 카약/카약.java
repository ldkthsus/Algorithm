import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char arr[][] = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        Point rank[] = new Point[10];
        rank[0] = new Point(-1, -1);

        for (int i = 0; i < r; i++) {
            int idx = 0;
            for (int j = 0; j < c; j++) {
                char word = arr[i][j];
                if (Character.isDigit(word)) {
                    idx = c - 1 - (j + 2);
                    rank[word - '0'] = new Point(word - '0', idx);
                    break;
                }
            }
        }
        Arrays.sort(rank);
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new TreeMap<>();
        int top = 0;
        for (int i = 1; i <= 9; i++) {
            if (rank[i].point == rank[i - 1].point) {
                map.put(rank[i].idx, top);
            } else {
                top++;
                map.put(rank[i].idx, top);
            }
        }
        for (int key : map.keySet()) {
            sb.append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }

    public static class Point implements Comparable<Point> {
        int idx;
        int point;

        public Point(int i, int p) {
            this.idx = i;
            this.point = p;
        }

        @Override
        public int compareTo(Point o) {
            return this.point - o.point;
        }
    }
}