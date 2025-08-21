import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() < M)
                continue;
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        Pair arr[] = new Pair[map.size()];
        int idx = 0;
        for (String key : map.keySet()) {
            arr[idx] = new Pair(key, key.length(), map.get(key));
            idx++;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i].str);
            sb.append("\n");
        }
//        String result = sb.toString();
//        result = result.substring(0, result.length() - 1);
//        System.out.println(result);
        System.out.println(sb.toString());
    }

    public static class Pair implements Comparable<Pair> {
        String str;
        int len;
        int cnt;

        public Pair(String s, int l, int c) {
            this.str = s;
            this.len = l;
            this.cnt = c;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.cnt == o.cnt) {
                if (this.len == o.len) {
                    int val = this.str.compareTo(o.str);
                    return val;
                } else {
                    return o.len - this.len;
                }
            } else
                return o.cnt - this.cnt;
        }
    }
}