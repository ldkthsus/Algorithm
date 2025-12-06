import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Point>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        list.add(new ArrayList<>());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).size() < m) {
                    if (list.get(j).isEmpty()) {
                        list.get(j).add(new Point(l, n));
                        if (list.get(j).size() < m)
                            break;
                    } else {
                        if (Math.abs(list.get(j).get(0).l - l) <= 10) {
                            list.get(j).add(new Point(l, n));
                            if (list.get(j).size() < m)
                                break;
                        } else {
                            if (j == list.size() - 1) {
                                list.add(new ArrayList<>());
                                list.get(j + 1).add(new Point(l, n));
                                break;
                            }
                        }
                    }
                    if (list.get(j).size() == m) {
                        list.add(new ArrayList<>());
                        break;
                    }
                }
            }
        }
        for (int a = 0; a < list.size(); a++) {
            Collections.sort(list.get(a));
            if (list.get(a).size() < m) {
                if (!list.get(a).isEmpty())
                    sb.append("Waiting!").append("\n");
            } else {
                sb.append("Started!").append("\n");
            }
            for (int b = 0; b < list.get(a).size(); b++) {
                sb.append(list.get(a).get(b).l).append(" ").append(list.get(a).get(b).n).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static class Point implements Comparable<Point> {
        int l;
        String n;

        public Point(int l, String n) {
            this.l = l;
            this.n = n;
        }

        @Override
        public int compareTo(Point o) {
            return this.n.compareTo(o.n);
        }
    }
}