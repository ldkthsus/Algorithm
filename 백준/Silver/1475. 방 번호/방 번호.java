import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int arr[] = new int[10];
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            arr[now - '0']++;
        }
        arr[6] += arr[9];
        arr[9] = 0;
        arr[6] = arr[6] / 2 + arr[6] % 2;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            max = Math.max(arr[i], max);
        }
        System.out.println(max);
    }
}