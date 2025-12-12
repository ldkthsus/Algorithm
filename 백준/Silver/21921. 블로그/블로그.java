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
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int days = 1;
        int sum = 0;

        while (true) {
            if (end == n) {
                if (max == sum)
                    days++;
                break;
            }

            if (end - start < k) {
                sum = sum + arr[end];
                end++;
            } else if (end - start == k) {
                if (max < sum) {
                    max = sum;
                    days = 1;
                } else if (max == sum) {
                    days++;
                }
                sum = sum - arr[start];
                start++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else
            System.out.println(max + "\n" + days);
    }
}