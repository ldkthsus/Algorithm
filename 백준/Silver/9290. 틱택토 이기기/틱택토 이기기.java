import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= TC; t++) {
            char arr[][] = new char[3][3];
            for (int i = 0; i < 3; i++) {
                String str = br.readLine();
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            char now = br.readLine().charAt(0);
            int x = -1;
            int y = -1;
            boolean check = false;
            for (int i = 0; i < 3; i++) {
                int cnt = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == now) {
                        cnt++;
                        map.put(j, 1);
                    }
                }
                if (cnt == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (!map.containsKey(j)) {
                            x = i;
                            y = j;
                            if (arr[x][y] == '-') {
                                check = true;
                                break;
                            }
                        }
                    }
                }
                if (check) {
                    sb.append("Case ").append(t).append(":").append("\n");
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            if (a == x && b == y) {
                                sb.append(now);
                            } else {
                                sb.append(arr[a][b]);
                            }
                        }
                        sb.append("\n");
                    }
                    break;
                }
            }
            if (!check) {
                for (int j = 0; j < 3; j++) {
                    int cnt = 0;
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int i = 0; i < 3; i++) {
                        if (arr[i][j] == now) {
                            cnt++;
                            map.put(i, 1);
                        }
                    }
                    if (cnt == 2) {
                        for (int i = 0; i < 3; i++) {
                            if (!map.containsKey(i)) {
                                x = i;
                                y = j;
                                if (arr[x][y] == '-') {
                                    check = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (check) {
                        sb.append("Case ").append(t).append(":").append("\n");
                        for (int a = 0; a < 3; a++) {
                            for (int b = 0; b < 3; b++) {
                                if (a == x && b == y) {
                                    sb.append(now);
                                } else {
                                    sb.append(arr[a][b]);
                                }
                            }
                            sb.append("\n");
                        }
                        break;
                    }
                }
            }
            if (!check) {
                int i = 0;
                int j = 0;
                int cnt = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int a = 0; a < 3; a++) {
                    if (arr[i][j] == now) {
                        cnt++;
                        map.put(a, 1);
                    }
                    i = i + 1;
                    j = j + 1;
                }
                if (cnt == 2) {
                    i--;
                    j--;
                    for (int a = 0; a < 3; a++) {
                        if (!map.containsKey(a)) {
                            x = i - (2 - a);
                            y = j - (2 - a);
                            if (arr[x][y] == '-') {
                                check = true;
                                break;
                            }
                        }
                    }
                }
                if (check) {
                    sb.append("Case ").append(t).append(":").append("\n");
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            if (a == x && b == y) {
                                sb.append(now);
                            } else {
                                sb.append(arr[a][b]);
                            }
                        }
                        sb.append("\n");
                    }
                }
            }
            if (!check) {
                int cnt = 0;
                int i = 0;
                int j = 2;
                Map<Integer, Integer> map = new HashMap<>();
                for (int a = 0; a < 3; a++) {
                    if (arr[i][j] == now) {
                        cnt++;
                        map.put(a, 1);
                    }
                    i = i + 1;
                    j = j - 1;
                }
                if (cnt == 2) {
                    i--;
                    j++;
                    for (int a = 0; a < 3; a++) {
                        if (!map.containsKey(a)) {
                            x = a;
                            y = 2 - a;
                            if (arr[x][y] == '-') {
                                check = true;
                                break;
                            }
                        }
                    }
                }
                if (check) {
                    sb.append("Case ").append(t).append(":").append("\n");
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            if (a == x && b == y) {
                                sb.append(now);
                            } else {
                                sb.append(arr[a][b]);
                            }
                        }
                        sb.append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}