import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, min, arr[];
    public static boolean isSelected[];
    public static List<Integer> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        isSelected = new boolean[n + 1];
        min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //인구수
        }
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            for (int j = 0; j < time; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i].add(a);
            }
        }
        subset(0);
        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(min);
    }

    public static void subset(int idx) {
        if (idx == n + 1) {
            Map<Integer, Integer> red = new HashMap<>();
            Map<Integer, Integer> blue = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                if (isSelected[i])
                    red.put(i, 1);
                else blue.put(i, 1);
            }
            if (red.size() == 0 || blue.size() == 0) {
                return;
            }
            if (bfs(red) && bfs(blue)) {
                int redCnt = 0;
                int blueCnt = 0;

                for(int key : red.keySet()){
                    redCnt += arr[key];
                }

                for(int key : blue.keySet()){
                    blueCnt += arr[key];
                }
                int result = Math.abs(redCnt - blueCnt);
                min = Math.min(min, result);
            }
            return;
        }
        isSelected[idx] = true;
        subset(idx + 1);
        isSelected[idx] = false;
        subset(idx + 1);
    }

    public static boolean bfs(Map<Integer, Integer> map) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[n + 1];
        int cnt = 1;
        for (int key : map.keySet()) {
            queue.offer(key);
            visited[key] = true;
            break;
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int d = 0; d < graph[now].size(); d++) {
                int next = graph[now].get(d);
                if (visited[next] || !map.containsKey(next))
                    continue;

                visited[next] = true;
                cnt++;
                queue.offer(next);
            }
        }
        if (cnt != map.size())
            return false;
        else return true;
    }
}