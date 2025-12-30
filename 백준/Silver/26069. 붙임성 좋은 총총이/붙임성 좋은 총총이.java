import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        map.put("ChongChong", 1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String before = st.nextToken();
            String after = st.nextToken();

            if(map.containsKey(before)){
                map.put(after, 1);
            }else if(map.containsKey(after)){
                map.put(before, 1);
            }
        }
        System.out.println(map.size());
    }
}