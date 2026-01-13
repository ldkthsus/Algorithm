import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        int arr[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        int ans = 0;
        while (true) {
            if (idx == m) {
                break;
            }
            if (deque.peekFirst() == arr[idx]) {
                idx++;
                deque.pollFirst();
            } else {
                int cha = deque.size() / 2;
                if (deque.size() % 2 != 0)
                    cha++;
                int cnt = 0;
                boolean check = false;
                for (int i = 0; i < cha; i++) {
                    int num = deque.peekFirst();
                    if (num == arr[idx]) {
                        ans += cnt;
                        check = true;
                        idx++;
                        deque.pollFirst();
                        break;
                    }
                    cnt++;
                    num = deque.pollFirst();
                    deque.offerLast(num);
                }
                if (!check) {
                    cnt = 0;
                    for (int i = 0; i < cha; i++) {
                        int num = deque.pollLast();
                        deque.offerFirst(num);
                    }
                    for (int i = 0; i < deque.size() - cha; i++) {
                        int num = deque.pollLast();
                        cnt++;
                        if (num == arr[idx]) {
                            ans += cnt;
                            idx++;
                            break;
                        }
                        deque.offerFirst(num);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}