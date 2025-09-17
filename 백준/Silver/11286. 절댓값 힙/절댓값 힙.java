import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Num> pq = new PriorityQueue<Num>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().num).append("\n");
                }
            } else {
                pq.offer(new Num(x, Math.abs(x)));
            }
        }
        System.out.println(sb);
    }

    public static class Num implements Comparable<Num> {
        int num;
        int abs;

        public Num(int n, int a) {
            this.num = n;
            this.abs = a;
        }

        @Override
        public int compareTo(Num o) {
            if (this.abs == o.abs) {
                return this.num - o.num;
            } else return this.abs - o.abs;
        }
    }
}