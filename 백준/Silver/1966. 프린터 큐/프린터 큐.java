import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            List<Integer> list = new ArrayList<>();
            Queue<Point> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //개수
            int m = Integer.parseInt(st.nextToken()); //원하는 번호

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                queue.offer(new Point(i, num));
            }
            Collections.sort(list, Collections.reverseOrder());
            int idx = 0;
            int cnt = 1;
            while (true) {
                if (idx == n) {
                    break;
                }
                int top = list.get(idx);
                int target = queue.peek().importance;
                if (top == target) {
                    Point now = queue.poll();
                    if (now.doc == m) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                    idx++;
                    cnt++;
                } else {
                    Point now = queue.poll();
                    queue.offer(new Point(now.doc, now.importance));
                }
            }
        }
        System.out.println(sb);
    }

    public static class Point {
        int doc;
        int importance;

        public Point(int d, int i) {
            this.doc = d;
            this.importance = i;
        }
    }
}