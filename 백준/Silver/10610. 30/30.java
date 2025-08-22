import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(n.charAt(i))));
        }
        Collections.sort(list, Collections.reverseOrder());
        if (list.get(list.size() - 1) != 0) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            sum = sum + list.get(i);
            sb.append(list.get(i));
        }
        if (sum % 3 == 0) {
            System.out.println(sb);
            return;
        }
        System.out.println(-1);
    }
}