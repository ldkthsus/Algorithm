import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int n, result[], arr[][], min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        result = new int[n / 2];
        arr = new int[n][n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
    }

    public static void comb(int idx, int cnt) {
        if (cnt == n / 2) {
            Map<Integer, Integer> start = new HashMap<>();
            Map<Integer, Integer> link = new HashMap<>();
            for (int i = 0; i < n / 2; i++) {
                start.put(result[i], 1);
            }
            for (int i = 0; i < n; i++) {
                if (!start.containsKey(i))
                    link.put(i, 1);
            }

            int sSum = 0;
            int lSum = 0;

            for (int key : start.keySet()) {
                for (int val : start.keySet()) {
                    if (key == val)
                        continue;

                    sSum += arr[key][val];
                }
            }

            for (int key : link.keySet()) {
                for (int val : link.keySet()) {
                    if (key == val)
                        continue;

                    lSum += arr[key][val];
                }
            }
            min = Math.min(Math.abs(sSum - lSum), min);
            return;
        }
        for (int i = idx; i < n; i++) {
            result[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }
}