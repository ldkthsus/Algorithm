import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < TC; t++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            int com[] = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i] = val;
            }

            int max = arr[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                if (max >= arr[i]) {
                    com[i] = max;
                } else {
                    max = arr[i];
                    com[i] = max;
                }
            }

            int cnt = 0;
            int sum = 0;
            long profit = 0;

            for (int i = 0; i < n; i++) {
                int val = arr[i];

                if (val == com[i]) {
                    profit += (long) com[i] * cnt - sum;
                    cnt = 0;
                    sum = 0;

                } else {
                    cnt++;
                    sum += val;
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}