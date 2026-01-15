import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b.put(Integer.parseInt(st.nextToken()), 1);
        }

        int ab = 0;
        for (int num : b.keySet()) {
            if (!a.containsKey(num))
                ab++;
        }
        int ba = 0;
        for (int num : a.keySet()) {
            if (!b.containsKey(num))
                ba++;
        }
        System.out.println(ab + ba);
    }
}