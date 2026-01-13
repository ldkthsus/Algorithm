import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int cnt = arr[1];
        int num = deque.pollFirst();
        sb.append(num).append(" ");
        while (true) {
            if (deque.isEmpty()) {
                break;
            }
            if (cnt > 0) {
                num = deque.pollFirst();
                cnt--;
            } else {
                num = deque.pollLast();
                cnt++;
            }
            if (cnt == 0) {
                cnt = arr[num];
                sb.append(num).append(" ");
            } else if(cnt > 0) {
                deque.offerLast(num);
            }
            else deque.offerFirst(num);
        }
        System.out.println(sb);
    }
}