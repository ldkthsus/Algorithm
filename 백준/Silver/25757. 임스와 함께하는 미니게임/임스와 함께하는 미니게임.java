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
        int N = Integer.parseInt(st.nextToken());
        char T = st.nextToken().charAt(0);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!map.containsKey(str)) {
                map.put(str, 1);
            }
        }
        if (T == 'Y') {
            System.out.println(map.size());
        } else if (T == 'F') {
            System.out.println(map.size() / 2);
        } else {
            System.out.println(map.size() / 3);
        }
    }
}