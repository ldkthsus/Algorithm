import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());
        int cnt = n / 3;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int idx = -1;

        while (true) {
            if (cnt == 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    sum += list.get(i);
                }
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (min > list.get(i)) {
                    min = list.get(i);
                    idx = i;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (idx == i)
                    continue;
                else {
                    sum += list.get(i);
                }
            }
            for (int i = 0; i < 3; i++) {
                list.remove(0);
            }
            min = Integer.MAX_VALUE;
            idx = -1;
            cnt--;
        }
        System.out.println(sum);
    }
}