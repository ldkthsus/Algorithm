import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = 0;
            int cnt = 0;
            while (true) {
                if (end == m)
                    break;
                int now = arr[i][end];
                if (now == 1) {
                    end++;
                    cnt = 0;
                } else {
                    if (cnt == 0)
                        start = end;
                    end++;
                    cnt++;
                }
                if (cnt == k) {
                    ans++;
                    start++;
                    cnt--;
                }
            }
        }
        System.out.println(ans);
    }
}