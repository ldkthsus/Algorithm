import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String s[] = str.split("");
            list.add(s);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.get(0).length; i++){
            String pre = list.get(0)[i];
            for(int j = 1; j < n; j++){
                String next = list.get(j)[i];
                if(!pre.equals(next)){
                    map.put(i, 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.get(0).length; i++){
            if(!map.containsKey(i))
                sb.append(list.get(0)[i]);
            else sb.append("?");
        }
        System.out.println(sb);
    }
}