import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Room> pq = new PriorityQueue<>(new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else return o1.start - o2.start;
            }
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Room now = pq.poll();
            if (queue.isEmpty()) {
                queue.offer(now.end);
            } else {
                if (queue.peek() <= now.start) {
                    queue.poll();
                }
                queue.offer(now.end);
            }
        }
        System.out.println(queue.size());
    }

    public static class Room {
        int start;
        int end;

        public Room(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
}