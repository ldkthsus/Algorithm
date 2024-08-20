import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean isEmpty[][], flag;
    public static int n, cost = Integer.MAX_VALUE, arr[][], result[], now;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        result = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(cost);
    }

    public static void comb(int idx, int start) {
        if (idx == 3) {
//            System.out.println("모든 결과 : " + Arrays.toString(result));
            flag = false;
            spread(result);
            if (flag == false) {
//                System.out.println("가능 : " + Arrays.toString(result));
                cal();

                cost = Math.min(cost, now);
//                System.out.println("now" + now);
//                System.out.println(cost);
            }
            return;
        }

        for (int i = start; i < n * n; i++) {
            result[idx] = i;
            comb(idx + 1, i + 1);
        }
    }

    public static void spread(int[] temp) {
        now = 0;
        isEmpty = new boolean[n][n];
        naga:
        for (int j = 0; j < temp.length; j++) {
            int nowi = temp[j] / n;
            int nowj = temp[j] % n;
            if (isEmpty[nowi][nowj]) {
                flag = true;
                break;
            }
            isEmpty[nowi][nowj] = true;

            for (int i = 0; i < 4; i++) {
                int nexti = nowi + dx[i];
                int nextj = nowj + dy[i];
                if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= n || isEmpty[nexti][nextj]) {
                    flag = true;
                    break naga;
                }
                isEmpty[nexti][nextj] = true;
            }
        }
    }

    public static void cal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isEmpty[i][j]) {
                    now += arr[i][j];
                }
            }
        }
    }
}