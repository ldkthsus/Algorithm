import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String ring[] = br.readLine().split("");
            boolean isUsed = false;
            for (int j = 0; j < ring.length; j++) {
                if (ring[j].equals(str[0])) {
                    int idx = j;
                    int k = 1;
                    while (true) {
                        if (k == str.length) {
                            isUsed = true;
                            break;
                        }
                        idx++;
                        if (idx > ring.length - 1)
                            idx = 0;

                        if (!ring[idx].equals(str[k]))
                            break;
                        k++;
                    }
                }
            }
            if (isUsed)
                cnt++;
        }
        System.out.println(cnt);
    }
}