import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Identify> pq = new PriorityQueue<>(new Comparator<Identify>() {
            @Override
            public int compare(Identify o1, Identify o2) {
                return o1.num - o2.num;
            }
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Identify(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Identify iden = pq.poll();
            String str = iden.str;
            int level = iden.level;
            sb.append(Character.toUpperCase(str.charAt(level - 1)));
        }
        System.out.println(sb);
    }

    public static class Identify {
        String str;
        int num;
        int level;

        public Identify(String s, int n, int l) {
            this.str = s;
            this.num = n;
            this.level = l;
        }
    }
}