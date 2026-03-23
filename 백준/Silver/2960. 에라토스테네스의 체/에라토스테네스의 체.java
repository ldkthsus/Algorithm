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
        int arr[] = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        int cnt = 0;
        int last = Integer.MIN_VALUE;
        int p = 2;
        naga:
        for (int i = 2; i <= n; i++) {
            if (i == p) {
                for (int j = 1; j <= n / p; j++) {
                    if (arr[p * j] != 0) {
                        last = arr[p * j];
                        arr[p * j] = 0;
                        cnt++;
                    }
                    if (cnt == k) {
                        System.out.println(last);
                        break naga;
                    }
                }

                for (int j = p; j <= n; j++) {
                    if (arr[j] != 0) {
                        p = j;
                        break;
                    }
                }
            }
        }
    }
}