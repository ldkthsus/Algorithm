import org.w3c.dom.ls.LSInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int before = Integer.parseInt(st.nextToken());
        int after = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            double temp = Math.pow(before, start);
            sum += (int) (arr[i] * temp);
            start++;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (sum == 0) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    sb.append(list.get(i)).append(" ");
                }
                break;
            }
            int val = sum % after;
            list.add(val);
            sum = sum / after;
        }

        System.out.println(sb);
    }
}