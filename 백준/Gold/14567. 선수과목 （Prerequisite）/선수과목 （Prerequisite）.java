import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];
        List<Integer> graph[] = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b]++;
            graph[a].add(b);
        }
        int time[] = new int[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0)
                queue.offer(i);
        }
        int cnt = 1;
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int now = queue.poll();
                for (int i = 0; i < graph[now].size(); i++) {
                    int sub = graph[now].get(i);
                    arr[sub]--;
                    if (arr[sub] == 0) {
                        queue.offer(sub);
                    }
                }
                time[now] = cnt;
            }
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(time[i]).append(" ");
        }
        System.out.println(sb);
    }
}