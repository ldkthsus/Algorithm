import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (i == 1)
                continue;
            if(i == 2 || i == 3|| i == 5 || i == 7)
                sb.append(i).append("\n");
            else {
                boolean check = false;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0){
                        check = true;
                        break;
                    }
                }
                if(!check){
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}