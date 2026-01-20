import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 10)
                cnt++;
            else {
                String str = String.valueOf(i);
                int val = 0;
                boolean check = false;
                boolean ans = true;
                for (int j = 0; j < str.length() - 1; j++) {
                    int pre = str.charAt(j) - '0';
                    int next = str.charAt(j + 1) - '0';
                    if (!check) {
                        val = pre - next;
                        check = true;
                    } else {
                        if (val != pre - next) {
                            ans = false;
                            break;
                        }
                    }
                }
                if (ans)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}