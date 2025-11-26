import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
            sum += val;
            if (!map.containsKey(val))
                map.put(val, 1);
            else map.put(val, map.get(val) + 1);
        }

        Arrays.sort(arr);
        List<Point> list = new ArrayList<>();

        for (int key : map.keySet()) {
            list.add(new Point(key, map.get(key)));
        }
        Collections.sort(list);
        int standCnt = list.get(0).cnt;
        int standNum = list.get(0).num;
        int result = 0;
        if (list.size() == 1) {
            result = standNum;
        } else {
            for (int i = 1; i < list.size(); i++) {
                int count = list.get(i).cnt;
                int number = list.get(i).num;
                if (standCnt == count) {
                    result = number;
                    break;
                } else if (standCnt > count) {
                    result = standNum;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double) sum / n)).append("\n");
        sb.append(arr[n / 2]).append("\n");
        sb.append(result).append("\n");
        sb.append(arr[n - 1] - arr[0]).append("\n");
        System.out.println(sb);
    }

    public static class Point implements Comparable<Point> {
        int num;
        int cnt;

        public Point(int n, int c) {
            this.num = n;
            this.cnt = c;
        }

        @Override
        public int compareTo(Point o) {
            if (this.cnt == o.cnt)
                return this.num - o.num;
            else return o.cnt - this.cnt;
        }
    }
}