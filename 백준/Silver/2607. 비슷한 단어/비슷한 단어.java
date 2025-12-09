import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        String standard = br.readLine();
        int alpha[] = new int[26];
        int stanCnt = 0;
        for (int i = 0; i < standard.length(); i++) {
            int now = standard.charAt(i) - 'A';
            alpha[now]++;
            stanCnt++;
        }

        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();
            int target[] = new int[26];
            int tarCnt = 0;

            for (int j = 0; j < str.length(); j++) {
                int now = str.charAt(j) - 'A';
                target[now]++;
                tarCnt++;
            }

            boolean check = true;
            int dif = 0;
            for (int j = 0; j < 26; j++) {
                int cha = Math.abs(alpha[j] - target[j]);
                if (cha >= 2) {
                    check = false;
                    break;
                } else if (cha == 1)
                    dif++;
            }
            if (check) {
                if (Math.abs(stanCnt - tarCnt) <= 1 && dif <= 2) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}