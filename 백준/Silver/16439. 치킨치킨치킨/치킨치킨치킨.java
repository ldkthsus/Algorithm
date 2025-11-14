import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //회원 수
        int m = Integer.parseInt(st.nextToken()); //치킨 수

        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j)
                    continue;
                for (int z = 0; z < m; z++) {
                    if (i == z || j == z)
                        continue;

                    int max;
                    int sum = 0;

                    for (int a = 0; a < n; a++) {
                        int one = arr[a][i];
                        int two = arr[a][j];
                        int three = arr[a][z];

                        max = Math.max(one, two);
                        max = Math.max(max, three);
                        sum += max;
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
        System.out.println(ans);
    }
}