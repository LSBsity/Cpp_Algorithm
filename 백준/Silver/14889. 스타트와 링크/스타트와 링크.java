import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(N);
        System.out.println(min);
    }

    private static void go(int N) {
        List<int[]> teamPairs = new ArrayList<>();
        combine(0, 0, N, N / 2, new ArrayList<>(), teamPairs);

        for (int[] teamA : teamPairs) {
            boolean[] selected = new boolean[N];
            for (int member : teamA) selected[member] = true;

            List<Integer> teamB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!selected[i]) teamB.add(i);
            }

            int sumA = 0;
            for (int i = 0; i < teamA.length - 1; i++) {
                for (int j = i + 1; j < teamA.length; j++) {
                    sumA += arr[teamA[i]][teamA[j]] + arr[teamA[j]][teamA[i]];
                }
            }
            int sumB = 0;
            for (int i = 0; i < teamB.size() - 1; i++) {
                for (int j = i + 1; j < teamB.size(); j++) {
                    Integer a = teamB.get(i);
                    Integer b = teamB.get(j);
                    sumB += arr[a][b] + arr[b][a];
                }
            }
            min = Math.min(min, Math.abs(sumA - sumB));
        }
    }

    public static void combine(int start, int depth, int n, int r, List<Integer> current, List<int[]> result) {
        if (depth == r) {
            if (current.contains(0)) {
                result.add(current.stream().mapToInt(i -> i).toArray());
            }
            return;
        }

        for (int i = start; i < n; i++) {
            current.add(i);
            combine(i + 1, depth + 1, n, r, current, result);
            current.remove(current.size() - 1);
        }
    }
}
