import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        int out = 0;
        int cnt = 0;
        int idx = -1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (true) {
            if (out == n) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(">");
                break;
            }
            idx++;
            if (idx >= n)
                idx = 0;
            if (arr[idx] == -1)
                continue;
            cnt++;
            if (cnt == k) {
                sb.append(arr[idx]).append(", ");
                arr[idx] = -1;
                cnt = 0;
                out++;
            }
        }
        System.out.println(sb);
    }
}