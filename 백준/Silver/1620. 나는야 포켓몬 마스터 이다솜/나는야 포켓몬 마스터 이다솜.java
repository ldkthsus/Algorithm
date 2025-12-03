import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> dogam = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            map.put(str, i);
            dogam.put(i, str);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            String str = br.readLine();
            if(Character.isDigit(str.charAt(0))){
                sb.append(dogam.get(Integer.parseInt(str))).append("\n");
            }
            else{
                sb.append(map.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}