import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int star = 0;
        String pattern = br.readLine();
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            if (pattern.charAt(i) == '*') {
                star = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(len > str.length() + 1){
                sb.append("NE").append("\n");
                continue;
            }
            boolean check = true;
            for (int j = 0; j < star; j++) {
                if (pattern.charAt(j) != str.charAt(j)) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                sb.append("NE").append("\n");
                continue;
            }
            int idx = str.length() - 1;
            for (int j = len - 1; j > star; j--) {
                if (pattern.charAt(j) != str.charAt(idx)) {
                    check = false;
                    break;
                }
                idx--;
            }
            if (!check) {
                sb.append("NE").append("\n");
            } else {
                sb.append("DA").append("\n");
            }
        }
        System.out.println(sb);
    }
}