import java.io.*;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;

    static int N;
    static int[][] arr;
    static boolean[] visited;

    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        go(1, 1);

        System.out.println(min);
    }

    private static void go(int idx, int depth) {
        if (depth == N / 2) {
            calc();
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            go(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static void calc() {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    sumA += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    sumB += arr[i][j] + arr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(sumA - sumB));
    }

}
