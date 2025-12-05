import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int start = -1;
        int end = -1;
        int sum = 0;
        while (true) {
            if (sum < m) {
                end++;
                if (end == n) {
                    break;
                }
                sum += arr[end];
            } else if (sum > m) {
                start++;
                sum -= arr[start];
            } else {
                cnt++;
                start++;
                sum -= arr[start];
            }
        }
        System.out.println(cnt);
    }
}