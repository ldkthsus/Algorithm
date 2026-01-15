import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>(); //문제 번호, 난이도
        int max = Integer.MIN_VALUE;
        int maxNum = 0;
        int min = Integer.MAX_VALUE;
        int minNum = 0;

        PriorityQueue<Point> maxs = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.l == o2.l)
                    return o2.p - o1.p;
                else return o2.l - o1.l;
            }
        });
        PriorityQueue<Point> mins = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.l == o2.l)
                    return o1.p - o2.p;
                else return o1.l - o2.l;
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            map.put(problem, level);
            if (max < level) {
                max = level;
                maxNum = problem;
            } else if (max == level) {
                maxNum = Math.max(maxNum, problem);
            }

            if (min > level) {
                min = level;
                minNum = problem;
            } else if (min == level) {
                minNum = Math.min(minNum, problem);
            }

            maxs.offer(new Point(problem, level));
            mins.offer(new Point(problem, level));
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("recommend")) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    sb.append(maxNum).append("\n");
                } else
                    sb.append(minNum).append("\n");
            } else if (order.equals("add")) {
                int problem = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                map.put(problem, level);
                if (max < level) {
                    max = level;
                    maxNum = problem;
                } else if (max == level) {
                    maxNum = Math.max(maxNum, problem);
                }

                if (min > level) {
                    min = level;
                    minNum = problem;
                } else if (min == level) {
                    minNum = Math.min(minNum, problem);
                }

                maxs.offer(new Point(problem, level));
                mins.offer(new Point(problem, level));
            } else {
                int pro = Integer.parseInt(st.nextToken());
                int val = map.get(pro); //난이도

                map.remove(pro);
                if (maxs.peek().p == pro) {
                    maxs.poll();
                    max = maxs.peek().l;
                    maxNum = maxs.peek().p;
                } else if (mins.peek().p == pro) {
                    mins.poll();
                    min = mins.peek().l;
                    minNum = mins.peek().p;
                }
            }
        }
        System.out.println(sb);
    }

    public static class Point {
        int p;
        int l;

        public Point(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
}