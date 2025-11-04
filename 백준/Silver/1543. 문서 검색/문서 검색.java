import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);

            if (word == target.charAt(0)) {
                boolean check = true;
                for (int j = 0; j < target.length(); j++) {
                    if (i + j >= str.length()) {
                        check = false;
                        break;
                    }
                    if (str.charAt(i + j) != target.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    cnt++;
                    i += target.length() - 1;
                }
            }
        }
        System.out.println(cnt);
    }
}