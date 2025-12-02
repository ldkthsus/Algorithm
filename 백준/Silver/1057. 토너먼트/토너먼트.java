import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int arr[] = new int[2];
        arr[0] = k;
        arr[1] = l;
        Arrays.sort(arr);

        int game = 1;
        boolean check = false;
        while (true) {
            if (n <= 0) {
                break;
            }
            int match = 0;
            if (arr[0] % 2 == 0)
                match = arr[0] - 1;
            else match = arr[0] + 1;

            if (match == arr[1]) {
                check = true;
                break;
            }
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n / 2 + 1;
            }
            for (int i = 0; i < 2; i++) {
                if (arr[i] % 2 == 0)
                    arr[i] = arr[i] / 2;
                else arr[i] = arr[i] / 2 + 1;
            }
            game++;
        }
        if (check)
            System.out.println(game);
        else System.out.println(-1);
    }
}