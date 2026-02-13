import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n, a, b;
    public static boolean visited[], check;
    public static List<Integer> arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
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
        visited = new boolean[n + 1];
        check = false;

        dfs(a, 0);
        if (!check)
            System.out.println(-1);
    }

    public static void dfs(int start, int depth) {
        visited[start] = true;
        if (start == b) {
            check = true;
            System.out.println(depth);
            return;
        }
        for (int i = 0; i < arr[start].size(); i++) {
            if (!visited[arr[start].get(i)])
                dfs(arr[start].get(i), depth + 1);
        }
    }
}