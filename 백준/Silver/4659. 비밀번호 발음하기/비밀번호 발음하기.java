import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mo = "aeiou";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < mo.length(); i++) {
            map.put(mo.charAt(i), 1);
        }

        while (true) {
            String str = br.readLine();
            boolean isMo = false;
            boolean three = false;
            boolean same = false;
            if (str.equals("end")) {
                break;
            }

            for(int i = 0; i < str.length(); i++){
                if(map.containsKey(str.charAt(i))){
                    isMo = true;
                    break;
                }
            }

            for (int i = 0; i <= str.length() - 3; i++) {
                if (map.containsKey(str.charAt(i))) {
                    if (map.containsKey(str.charAt(i + 1)) && map.containsKey(str.charAt(i + 2))) {
                        three = true;
                        break;
                    }
                } else {
                    if (!map.containsKey(str.charAt(i + 1)) && !map.containsKey(str.charAt(i + 2))) {
                        three = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == 'e' || str.charAt(i) == 'o') {
                    continue;
                }
                if(str.charAt(i) == str.charAt(i + 1)){
                    same = true;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append('<').append(str).append('>').append(" ");

            if (isMo && !three && !same) {
                sb.append("is acceptable.");
            } else {
                sb.append("is not acceptable.");
            }

            System.out.println(sb);
        }
    }
}