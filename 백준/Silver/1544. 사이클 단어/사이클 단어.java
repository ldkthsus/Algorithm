import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String word[] = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
        //시작점을 찾아서 단어를 map에서 확인

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String now = word[i];
            boolean check = false;

            for(int j = 0; j < now.length(); j++){

                String newWord = "";

                int cnt = 0;
                int idx = j;

                while(true){
                    if(cnt == now.length()){
                        break;
                    }
                    newWord += now.charAt(idx);
                    idx++;
                    idx = idx % now.length();
                    cnt++;
                }

                if(map.containsKey(newWord)){
                    check = true;
                    break;
                }
            }
            if(!check){
                map.put(now, 1);
            }
        }
        System.out.println(map.size());
    }
}