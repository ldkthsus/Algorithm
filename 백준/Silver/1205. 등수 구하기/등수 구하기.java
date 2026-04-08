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
        int n = Integer.parseInt(st.nextToken()); //현재 랭킹에 있는 점수 개수
        int tae = Integer.parseInt(st.nextToken()); //태수 저수
        int p = Integer.parseInt(st.nextToken()); //랭킹에 등록할 수 있는 개수
        if (n == 0) {
            if (p == 0) {
                System.out.println(-1);
                return;
            } else {
                System.out.println(1);
                return;
            }
        }
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Song> list = new ArrayList<>();
        boolean check = false;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (!check) {
                if (now > tae) {
                    list.add(new Song(now, i + 1));
                } else {
                    list.add(new Song(tae, i + 1));
                    list.add(new Song(now, i + 1));
                    check = true;
                }
            } else {
                list.add(new Song(now, i + 1));
            }
        }

        if (list.size() == n) {
            list.add(new Song(tae, n + 1));
        }
        int idx = 1;
        int cnt = 1;
        boolean isSame = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).score == list.get(i + 1).score) {
                if (!isSame) {
                    idx = list.get(i).rank;
                    isSame = true;
                }
                list.get(i).rank = idx;
                cnt++;
            } else if (list.get(i).score > list.get(i + 1).score) {
                if (cnt > 1) {
                    isSame = false;
                    list.get(i).rank = idx;
                    idx = idx + cnt;
                    cnt = 1;
                } else {
                    list.get(i).rank = idx;
                    idx++;
                }
            }
            if (i + 1 == list.size() - 1) {
                int pre = list.get(i).score;
                if (pre == list.get(i + 1).score) {
                    list.get(i + 1).rank = idx;
                } else {
                    if (cnt > 1) {
                        list.get(i + 1).rank = idx + cnt;
                    } else {
                        list.get(i + 1).rank = idx;
                    }
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i).score;
            if (val == tae) {
                if (i + 1 > p) {
                    ans = -1;
                    break;
                } else {
                    ans = list.get(i).rank;
                }
            }
        }
        System.out.println(ans);
    }

    public static class Song {
        int score;
        int rank;

        public Song(int s, int r) {
            this.score = s;
            this.rank = r;
        }
    }
}