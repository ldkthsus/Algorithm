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
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        char arr[] = {'A', 'C', 'G', 'T'};
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            map.put(arr[i], Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = -1;
        int cnt = 0;
        int ans = 0;
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            target.put(arr[i], 0);
        }
        while (true) {
            if (cnt < t) {
                end++;
                if (end == s) {
                    break;
                }
                char now = str.charAt(end);
                target.put(now, target.get(now) + 1);
                cnt++;
            } else if (cnt == t) {
                boolean check = true;
                for (char key : map.keySet()) {
                    if (map.get(key) > target.get(key)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    ans++;
                }
                char now = str.charAt(start);
                target.put(now, target.get(now) - 1);
                start++;
                cnt--;
            }
        }
        System.out.println(ans);
    }
}