import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
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
        int ans = Integer.MIN_VALUE;
        int cnt = 0;
        int hol = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        while (true) {
            if (end == n) {
                ans = Math.max(ans, cnt);
                break;
            }
            if (hol < k) {
                if (arr[end] % 2 != 0) {
                    arr[end] = 0;
                    queue.offer(end);
                    end++;
                    hol++;
                } else {
                    end++;
                    cnt++;
                }
            } else {
                if (arr[end] % 2 == 0) {
                    cnt++;
                    end++;
                } else {
                    ans = Math.max(ans, cnt);
                    if (!queue.isEmpty()) {
                        start = queue.poll();
                        hol--;
                        cnt = end - 1 - start - hol;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}