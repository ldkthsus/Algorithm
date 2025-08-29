import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>(); //숫자, 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 0);
        }

        int start = 0;
        int end = 0;
        int ans = Integer.MIN_VALUE;
        int cnt = 0;

        while (true) {
            if (end == n) {
                ans = Math.max(ans, cnt);
                break;
            }
            map.put(arr[end], map.get(arr[end]) + 1);
            int val = map.get(arr[end]);
            cnt++;
            if (val > k) {
                cnt--;
                ans = Math.max(cnt, ans);
                while (true) {
                    map.put(arr[start], map.get(arr[start]) - 1);
                    cnt--;
                    start++;
                    if (map.get(arr[end]) <= k) {
                        cnt++;
                        break;
                    }
                }
            }
            end++;
        }
        System.out.println(ans);
    }
}