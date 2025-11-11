import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int cnt = 0;

        while (true) {
            if (start >= end)
                break;

            int result = arr[start] + arr[end];
            if (result == M) {
                cnt++;
                start++;
            } else if (result > M) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(cnt);
    }
}