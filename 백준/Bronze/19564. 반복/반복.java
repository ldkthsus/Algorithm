import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int k = 1;

        for (int i = 0; i < n; i++) {
            char now = str.charAt(i);
            if(i == n - 1){
                break;
            }
            if (now >= str.charAt(i + 1)) {
                k++;
            }
        }
        System.out.println(k);
    }
}