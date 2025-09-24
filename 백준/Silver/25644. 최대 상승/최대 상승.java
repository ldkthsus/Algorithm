import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int sum = 0;

        while (true) {
            if (end == arr.length) {
                break;
            }
            if (arr[start] >= arr[end]){
                start = end;
                sum = Math.max(sum, arr[start] - arr[end]);
                end++;
            }
            else if(arr[start] < arr[end]){
                sum = Math.max(sum, arr[end] - arr[start]);
                end++;
            }
        }
        System.out.println(sum);
    }
}