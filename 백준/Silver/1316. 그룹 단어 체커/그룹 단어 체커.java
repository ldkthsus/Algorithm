import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int t = 0; t < n; t++) {
            String str = br.readLine();
            boolean alpha[] = new boolean[26];
            boolean check = true;

            for(int i = 0; i < str.length(); i++){
                char word = str.charAt(i);
                if(!alpha[word - 'a']){
                    alpha[word - 'a'] = true;
                }
                else{
                    if(word != str.charAt(i - 1)){
                        check = false;
                        break;
                    }
                }
            }
            if(check)
                cnt++;
        }
        System.out.println(cnt);
    }
}