import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, M, A;

    static int[] arrA, arrB;

    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    static List<int[]> bcList;

    static int totalCharge;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            arrA = new int[M];
            arrB = new int[M];

            bcList = new ArrayList<>();
            totalCharge = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                bcList.add(new int[]{y - 1, x - 1, num, power});
            }

            go();

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(totalCharge)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go() {
        int[] aPos = new int[]{0, 0};
        int[] bPos = new int[]{9, 9};

        for (int i = 0; i <= M; i++) {
            if (i != 0) {
                int aDir = arrA[i - 1];
                int bDir = arrB[i - 1];

                aPos[0] += dx[aDir];
                aPos[1] += dy[aDir];

                bPos[0] += dx[bDir];
                bPos[1] += dy[bDir];
            }

            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for (int j = 0; j < A; j++) {
                int[] bcPos = bcList.get(j);
                if (manhattan(aPos, bcPos) <= bcPos[2]) {
                    aList.add(j);
                }
                if (manhattan(bPos, bcPos) <= bcPos[2]) {
                    bList.add(j);
                }
            }

            totalCharge += getMaxCharge(aList, bList);
        }
    }

    private static int getMaxCharge(List<Integer> aList, List<Integer> bList) {
        int maxCharge = 0;
        if (!aList.isEmpty() && !bList.isEmpty()) {
            for (int aBC : aList) {
                for (int bBC : bList) {
                    int chargeA, chargeB;
                    
                    if (aBC == bBC) {
                        chargeA = bcList.get(aBC)[3] / 2;
                        chargeB = bcList.get(bBC)[3] / 2;
                    } else {
                        chargeA = bcList.get(aBC)[3];
                        chargeB = bcList.get(bBC)[3];
                    }
                    maxCharge = Math.max(maxCharge, chargeA + chargeB);
                }
            }
        } else if (!aList.isEmpty()) {
            for (int aBC : aList) {
                maxCharge = Math.max(maxCharge, bcList.get(aBC)[3]);
            }
        } else if (!bList.isEmpty()) {
            for (int bBC : bList) {
                maxCharge = Math.max(maxCharge, bcList.get(bBC)[3]);
            }
        } else {
            maxCharge = 0;
        }
        return maxCharge;
    }

    private static int manhattan(int[] aPos, int[] bPos) {
        return Math.abs(aPos[0] - bPos[0]) + Math.abs(aPos[1] - bPos[1]);
    }
}
