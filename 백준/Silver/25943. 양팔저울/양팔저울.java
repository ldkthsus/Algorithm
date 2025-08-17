import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arr[] = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int chu[] = {100, 50, 20, 10, 5, 2, 1};

        int left = arr[0];
        int right = arr[1];

        for (int i = 2; i < num; i++) {
            if (left == right) {
                left = left + arr[i];
            } else {
                if (left > right)
                    right = right + arr[i];
                else
                    left = left + arr[i];
            }
        }

        if (left == right)
            System.out.println(0);
        else {
            int min = Math.min(left, right);
            int cha = Math.abs(left - right);
            int cnt = 0;

            for (int i = 0; i < 7; i++) {
                if (cha < chu[i])
                    continue;

                cnt = cnt + (cha / chu[i]);
                cha = cha % chu[i];
            }
            System.out.println(cnt);
        }
    }
}