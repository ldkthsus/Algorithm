import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean check = false;
        int idx = 0;
        sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);

            if (word == '.') {
                int cha = i - idx;
                check = true;
                int value = poly(cha);
                if (value != 0) {
                    System.out.println(-1);
                    return;
                }
                idx = i + 1;
                sb.append(".");
                if (idx == str.length()) {
                    break;
                }
            }
        }

        if (check) {
            int cha = str.length() - idx;
            int value = poly(cha);
            if (value != 0) {
                System.out.println(-1);
            } else {
                System.out.println(sb);
            }

        } else {
            int value = poly(str.length());
            if (value != 0) {
                System.out.println(-1);
            } else System.out.println(sb);
        }
    }

    public static int poly(int len) {
        int result = len / 4;
        for (int j = 0; j < result; j++) {
            sb.append("AAAA");
        }
        if (result == 0) {
            result = len;
        } else {
            result = len % 4;
        }

        int value = result / 2;

        for (int j = 0; j < value; j++) {
            sb.append("BB");
        }
        return result % 2;
    }
}