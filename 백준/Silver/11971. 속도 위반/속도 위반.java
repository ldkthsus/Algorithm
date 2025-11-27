import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[101];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int km = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            for (int j = sum + 1; j <= sum + km; j++) {
                arr[j] = limit;
            }
            sum = sum + km;
        }

        int dis = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int km = Integer.parseInt(st.nextToken());
            int drive = Integer.parseInt(st.nextToken());
            int cha = Integer.MIN_VALUE;

            for (int j = dis + 1; j <= dis + km; j++) {
                cha = Math.max(cha, drive - arr[j]);
            }
            list.add(cha);
            dis += km;
        }
        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                System.out.println(list.get(i));
                return;
            }
        }
        System.out.println(0);
    }
}