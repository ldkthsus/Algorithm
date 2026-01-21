import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean alpha[] = new boolean[26];
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            Arrays.fill(alpha, false);
            boolean check = true;
            for(int j = 0; j < str.length(); j++){
                char now = str.charAt(j);
                if(!alpha[now - 'a']){
                    alpha[now - 'a'] = true;
                }else{
                    char pre = str.charAt(j - 1);
                    if(pre != now){
                        check = false;
                        break;
                    }
                }
            }
            if(check)
                ans++;
        }
        System.out.println(ans);
    }
}