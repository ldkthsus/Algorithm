import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String str[] = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        Map<Character, Integer> map = new HashMap<>();
        char cycle[] = {'P', 'C', 'V', 'S', 'G', 'F'};
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            map.put(cycle[i], Integer.parseInt(st.nextToken()));
        }
        map.put('O', Integer.parseInt(br.readLine()));
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String trash = str[i];
            Map<Character, Integer> target = new HashMap<>();

            for (int j = 0; j < trash.length(); j++) {
                char now = trash.charAt(j);

                if (!target.containsKey(now))
                    target.put(now, 1);
                else target.put(now, target.get(now) + 1);
            }

            if (target.size() > 1)
                list.add('O');
            else {
                for (char key : target.keySet()) {
                    list.add(key);
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            char word = list.get(i);
            int val = map.get(word);
            int gen = map.get('O');
            if (val > gen)
                sum += (long) gen * str[i].length();
            else sum += (long) val * str[i].length();
        }
        System.out.println(sum);
    }
}