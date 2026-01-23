import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static int n;
    public static boolean isUsed[];
    public static TreeSet<String> set;
    public static String sign[];
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");
        set = new TreeSet<>();
        isUsed = new boolean[10];
        sb = new StringBuilder();

        comb(0, -1);
        System.out.println(set.last());
        System.out.println(set.first());
    }

    public static void comb(int idx, int pre) {
        if (idx == n + 1) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (idx == 0) {
                if (!isUsed[i]) {
                    sb.append(i);
                    isUsed[i] = true;
                    comb(idx + 1, i);
                    isUsed[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                if (sign[idx - 1].equals(">")) {
                    if (!isUsed[i] && pre > i) {
                        sb.append(i);
                        isUsed[i] = true;
                        comb(idx + 1, i);
                        isUsed[i] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    if (!isUsed[i] && pre < i) {
                        sb.append(i);
                        isUsed[i] = true;
                        comb(idx + 1, i);
                        isUsed[i] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
    }
}