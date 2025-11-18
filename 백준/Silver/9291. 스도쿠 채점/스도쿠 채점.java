import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int arr[][] = new int[9][9];
            boolean flag = true;
            boolean ok = true;
            boolean check = true;

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            naga:
            for (int i = 0; i < 9; i++) {
                int temp[] = new int[9];
                for (int j = 0; j < 9; j++) {
                    temp[j] = arr[i][j];
                }
                flag = jul(temp);
                if (!flag)
                    break naga;
            }

            out:
            for (int i = 0; i < 9; i++) {
                int temp[] = new int[9];
                for (int j = 0; j < 9; j++) {
                    temp[j] = arr[j][i];
                }
                ok = jul(temp);
                if (!ok)
                    break out;
            }

            fin:
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    int temp[][] = new int[3][3];
                    for (int a = i; a < i + 3; a++) {
                        for (int b = j; b < j + 3; b++) {
                            temp[a % 3][b % 3] = arr[a][b];
                        }
                    }
                    check = square(temp);
                    if (!check)
                        break fin;
                }
            }

            if (flag && ok && check)
                System.out.println("Case " + t + ": CORRECT");
            else
                System.out.println("Case " + t + ": INCORRECT");
        }
    }

    public static boolean jul(int arr[]) {
        boolean check[] = new boolean[10];
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            if (!check[arr[i]]) {
                check[arr[i]] = true;
                cnt++;
            } else {
                return false;
            }
        }
        if (cnt == 9)
            return true;
        else
            return false;
    }

    public static boolean square(int arr[][]) {
        boolean check[] = new boolean[10];
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!check[arr[i][j]]) {
                    check[arr[i][j]] = true;
                    cnt++;
                } else {
                    return false;
                }
            }
        }
        if (cnt == 9)
            return true;
        else
            return false;
    }
}