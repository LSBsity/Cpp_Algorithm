import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static char[][] map, temp;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new char[N][N];
            temp = new char[N][N];

            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    map[i][j] = chars[j];
                }
            }

            int r = go(map);
            rotate();
            int c = go(temp);

            sb.append(r)
                    .append(' ')
                    .append(c);
        }

        System.out.print(sb);
    }

    private static void rotate() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[N - 1 - j][i] = map[i][j];
            }
        }
    }

    private static int go(char[][] map) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            char[] row = map[i];

            boolean beforeWall = true;
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (beforeWall) {
                    if (row[j] == '.') {
                        cnt++;
                        beforeWall = false;
                    } else if (row[j] == 'X') {
                        cnt = 0;
                    }
                } else {
                    if (row[j] == '.') {
                        cnt++;
                    } else if (row[j] == 'X') {
                        cnt = 0;
                        beforeWall = true;
                    }
                }

                if (cnt >= 2) {
                    answer++;
                    while (j < N && row[j] != 'X') {
                        j++;
                    }
                    beforeWall = true;
                    cnt = 0;
                }
            }
        }

        return answer;
    }
}
