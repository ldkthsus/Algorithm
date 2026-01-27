import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                union(a, b);
            } else {
                if(find(a) == find(b))
                    sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int a){
        if(parent[a] == a)
            return a;

        return find(parent[a]);
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            parent[B] = A;
        }
    }
}