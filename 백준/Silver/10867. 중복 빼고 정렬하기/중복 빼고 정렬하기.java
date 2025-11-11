import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (!map.containsKey(val)) {
                map.put(val, 1);
            }
        }
        int arr[] = new int[map.size()];
        int idx = 0;
        for (int key : map.keySet()) {
            arr[idx] = key;
            idx++;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}