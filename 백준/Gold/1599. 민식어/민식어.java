import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "a b k d e g h i l m n ng o p r s t u w y";
        StringTokenizer st = new StringTokenizer(str);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            String alpha = st.nextToken();
            map.put(alpha, i + 1);
        }
//        System.out.println(map.toString());
        int num = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(br.readLine());
        }
        List<String> total = new ArrayList<>();
        Map<String, String> miniMap = new HashMap<>(); //점수, 해당하는 문자열
        for (int i = 0; i < num; i++) {
            String word = list.get(i);
            String score = "";
            for (int j = 0; j < word.length(); j++) {
                char now = word.charAt(j);
                if (now == 'n' && j != word.length() - 1 && word.charAt(j + 1) == 'g') {
                    String spe = String.valueOf(map.get("ng"));
                    score = score + spe + " ";
                    j++;
                    continue;
                }
                String number = String.valueOf(map.get(String.valueOf(now)));
                score = score + number + " ";
            }
            score = score.substring(0, score.length() - 1);
            total.add(score);
            miniMap.put(score, word);
        }
//        System.out.println(total.toString());
        Collections.sort(total, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] a1 = s1.split(" ");
                String[] a2 = s2.split(" ");

                int len = Math.min(a1.length, a2.length);

                for (int i = 0; i < len; i++) {
                    int n1 = Integer.parseInt(a1[i]);
                    int n2 = Integer.parseInt(a2[i]);

                    if (n1 != n2) {
                        return n1 - n2; // 숫자로 비교
                    }
                }

                // 앞의 숫자들이 모두 같을 경우, 길이 짧은 게 먼저
                return a1.length - a2.length;
            }
        });

//        System.out.println(total.toString());
//        System.out.println(miniMap.toString());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total.size(); i++) {
            String number = total.get(i);
            if (miniMap.containsKey(number)) {
                sb.append(miniMap.get(number));
                if (i != total.size() - 1)
                    sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}