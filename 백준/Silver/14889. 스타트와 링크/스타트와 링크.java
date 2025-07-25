import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;  
        dfs(1, 1);
        System.out.println(min);
    }

    private static void dfs(int idx, int depth) {
        if (depth == N / 2) {
            calcDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static void calcDiff() {
        int teamA = 0, teamB = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamA += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamB += arr[i][j] + arr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(teamA - teamB));
    }
}
