import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int friend[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            friend[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int num = friend[i];
            for(int j = 0; j < n; j++){
                if(num == arr[j]){
                    list.add(j);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) >= m)
                ans++;
        }
        System.out.println(ans);
    }
}