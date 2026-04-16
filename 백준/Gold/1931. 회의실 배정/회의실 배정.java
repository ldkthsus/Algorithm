import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        int ans = 0;
        int now = 0;
        for(int i = 0; i < n; i++){
            if(now <= list.get(i).start){
                now = list.get(i).end;
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Room o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } else return this.end - o.end;
        }
    }
}