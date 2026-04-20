import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
            graph[a].add(b);
            arr[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0)
                pq.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (pq.isEmpty()) {
                break;
            }
            int num = pq.poll();
            sb.append(num).append(" ");
            for (int i = 0; i < graph[num].size(); i++) {
                int val = graph[num].get(i);
                arr[val]--;
                if (arr[val] == 0)
                    pq.offer(val);
            }
        }
        System.out.println(sb);
    }
}