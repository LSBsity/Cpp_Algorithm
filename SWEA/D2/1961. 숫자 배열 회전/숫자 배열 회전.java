import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            List<StringBuilder> sbs = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                sbs.add(new StringBuilder());
            }
            int[][] temp = arr;
            for (int i = 0; i < 3; i++) {
                temp = solve(temp);
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        sbs.get(j).append(temp[j][k]);
                    }
                    if (i <= 1) sbs.get(j).append(" ");
                }
            }
            System.out.printf("#%d\n", t);
            for (StringBuilder sb : sbs) {
                System.out.println(sb.toString());
            }
        }
    }

    private static int[][] solve(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] rotated = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - i - 1] = arr[i][j];
            }
        }

        return rotated;
    }
}