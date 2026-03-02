import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, result[], number[];
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        number = new int[n];
        result = new int[m];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
        comb(0, 0);
        System.out.println(sb);
    }
    public static void comb(int idx, int start){
        if(idx == m){
            for(int i = 0; i < m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < n; i++){
            result[idx] = number[i];
            comb(idx + 1, i + 1);
        }
    }
}