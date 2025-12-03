import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>(); //문자열 길이
            Map<Character, Integer> map = new HashMap<>(); //소문자가 맨 처음 나온 위치
            int arr[] = new int[26]; //소문자가 나온 횟수
            List<Integer> alpha[] = new List[26]; //소문자가 나온 다음 인덱스들
            for (int i = 0; i < 26; i++) {
                alpha[i] = new ArrayList<>();
            }

            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);
                if (!map.containsKey(now)) {
                    map.put(now, i);
                    arr[now - 'a'] = 1;
                } else {
                    arr[now - 'a']++;
                    alpha[now - 'a'].add(i);
                }

                if (arr[now - 'a'] == k) {
                    int cha = i - map.get(now) + 1;
                    list.add(cha);

                    if(alpha[now - 'a'].isEmpty())
                        continue;
                    map.put(now, alpha[now - 'a'].get(0));
                    arr[now - 'a']--;
                    alpha[now - 'a'].remove(0);
                }
            }
            Collections.sort(list);
            if (list.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                Collections.sort(list);
                sb.append(list.get(0)).append(" ").append(list.get(list.size() - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}