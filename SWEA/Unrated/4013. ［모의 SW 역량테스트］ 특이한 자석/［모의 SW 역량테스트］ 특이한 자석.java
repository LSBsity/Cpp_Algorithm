import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, K;

    static List<List<Integer>> magnets;

    static int num, dir;

    static int[] idx = { 2, 6 };

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            magnets = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                List<Integer> magnet = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    magnet.add(Integer.parseInt(st.nextToken()));
                }
                magnets.add(magnet);
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                num = Integer.parseInt(st.nextToken()) - 1;
                dir = Integer.parseInt(st.nextToken());

                int[] rotateDir = new int[4];
                rotateDir[num] = dir;

                for (int left = num - 1; left >= 0; left--) {
                    if (magnets.get(left).get(2) != magnets.get(left + 1).get(6)) {
                        rotateDir[left] = -rotateDir[left + 1];
                    } else {
                        break; 
                    }
                }

                for (int right = num + 1; right < 4; right++) {
                    if (magnets.get(right - 1).get(2) != magnets.get(right).get(6)) {
                        rotateDir[right] = -rotateDir[right - 1];
                    } else {
                        break;
                    }
                }

                for (int j = 0; j < 4; j++) {
                    if (rotateDir[j] != 0) {
                        rotate(j, rotateDir[j]);
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < 4; i++) {
                if (magnets.get(i).get(0) == 1) {
                    sum += (1 << i); 
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }

    static void rotate(int idx, int dir) {
        Collections.rotate(magnets.get(idx), dir);
    }
}