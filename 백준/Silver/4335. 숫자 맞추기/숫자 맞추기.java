import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = 10;
        int min = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                String stan = br.readLine();
                if (stan.equals("right on")) {
                    if (n >= min && n <= max)
                        sb.append("Stan may be honest").append("\n");
                    else {
                        sb.append("Stan is dishonest").append("\n");
                    }
                    min = 1;
                    max = 10;
                } else {
                    if (stan.equals("too high")) {
                        max = Math.min(n - 1, max);
                    } else {
                        min = Math.max(min, n + 1);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}