import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans[] = new int[n];
        int idx = 0;
        for (int i = n; i > 0; i--) {
            int val = arr[i];
            if (val >= idx) {
                ans[idx] = i;
            } else {
                List<Integer> list = new ArrayList<>();
                for (int j = val; j < idx; j++) {
                    list.add(ans[j]);
                }
                ans[val] = i;
                int index = 0;
                for (int j = val + 1; j <= idx; j++) {
                    ans[j] = list.get(index);
                    index++;
                }
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}