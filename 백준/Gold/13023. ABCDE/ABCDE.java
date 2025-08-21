import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static List<Integer> arr[];
    public static boolean visited[], check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
            arr[to].add(from);
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }
        if (check)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void dfs(int start, int depth) {
        if (depth == 4) {
            check = true;
            return;
        }

        for (int i = 0; i < arr[start].size(); i++) {
            if (!visited[arr[start].get(i)]) {
                visited[arr[start].get(i)] = true;
                dfs(arr[start].get(i), depth + 1);
                visited[arr[start].get(i)] = false;
                if (check)
                    return;
            }
        }
    }
}