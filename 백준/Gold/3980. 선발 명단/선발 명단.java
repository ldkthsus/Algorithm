import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[] isUsed;
    public static int []result, player;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            arr = new int[11][11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            player = new int[11];
            for (int i = 0; i < 11; i++) {
                player[i] = i;
            }
            answer = 0;
            isUsed = new boolean[11];
            result = new int[11];
            perm(0);
            System.out.println(answer);
        }
    }
    public static void perm(int idx) {
        if (idx == 11) {
            int sum = 0;
            for (int i = 0; i < 11; i++) {
                int val = arr[result[i]][i];
                sum = sum + val;
            }
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!isUsed[i]) {
                if(arr[player[i]][idx] == 0)
                    continue;
                result[idx] = player[i];
                isUsed[i] = true;
                perm(idx + 1);
                isUsed[i] = false;
            }
        }
    }
}