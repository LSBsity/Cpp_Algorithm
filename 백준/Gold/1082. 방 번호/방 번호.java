import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] P;

    public static void main(String[] args) throws Exception {

        int[] temp = new int[51];
        int idx = 0;

        N = Integer.parseInt(br.readLine());
        P = new int[N];

        st = new StringTokenizer(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            list.add(new int[] { i, P[i] });
        }

        M = Integer.parseInt(br.readLine());
        int remain = M;

        Collections.sort(list, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        if (list.size() == 1) {
            System.out.println(0);
            return;
        }

        int[] minDigit = list.get(0);
        int[] firstDigit = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] != 0) {
                firstDigit = list.get(i);
                break;
            }
        }

        if (firstDigit == null || firstDigit[1] > remain) {
            System.out.println(0);
            return;
        }

        temp[idx++] = firstDigit[0];
        remain -= firstDigit[1];

        while (remain >= minDigit[1]) {
            temp[idx++] = minDigit[0];
            remain -= minDigit[1];
        }

        int changeIdx = N - 1;
        for (int i = 0; i < idx; i++) {

            int current = temp[i]; // 현재 자리의 숫자
            int cost = P[current]; // 현재 자리 숫자의 비용

            int big = changeIdx; // 가장 큰 숫자
            int bigCost = P[changeIdx]; // 가장 큰 숫자의 비용

            if (bigCost >= cost) {
                int diff = bigCost - cost;

                if (remain - diff < 0) {
                    while (changeIdx >= 0 && remain - (P[changeIdx] - cost) < 0) {
                        changeIdx--;
                    }

                    diff = P[changeIdx] - cost;
                    big = changeIdx;
                }
                temp[i] = big;
                remain -= diff;
            } else {
                changeIdx--;
            }

        }

        for (int i = 0; i < idx; i++) {
            System.out.print(temp[i]);
        }
    }

}