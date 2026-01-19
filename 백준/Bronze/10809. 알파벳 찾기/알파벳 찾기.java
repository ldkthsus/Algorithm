import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (!map.containsKey(now))
                map.put(now, i);
        }
        StringBuilder sb = new StringBuilder();
        char alpha = 'a';
        for (int i = 0; i < 26; i++) {
            if(map.containsKey(alpha))
                sb.append(map.get(alpha)).append(" ");
            else sb.append(-1).append(" ");

            alpha++;
        }
        System.out.println(sb);
    }
}