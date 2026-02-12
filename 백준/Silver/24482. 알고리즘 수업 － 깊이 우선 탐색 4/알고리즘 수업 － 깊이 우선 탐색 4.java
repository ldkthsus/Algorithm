import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m, result[];
    public static boolean visited[];
    public static List<Integer> arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        result = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(result, -1);

        for (int i = 0; i <= n; i++) {
            Collections.sort(arr[i], Collections.reverseOrder());
        }
        dfs(point, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        visited[start] = true;
        result[start] = depth;

        for (int i = 0; i < arr[start].size(); i++) {
            if (!visited[arr[start].get(i)])
                dfs(arr[start].get(i), depth + 1);
        }
    }
}