import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int change = 1000 - n;
        int ans = 0;

        int arr[] = {500, 100, 50, 10, 5, 1};

        for (int i = 0; i < 6; i++) {
            int val = change / arr[i];
            int rest = change % arr[i];

            if (rest == 0) {
                ans += val;
                break;
            } else {
                ans += val;
                change = rest;
            }
        }
        System.out.println(ans);
    }
}