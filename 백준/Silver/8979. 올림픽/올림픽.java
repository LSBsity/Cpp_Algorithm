import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[][]> list = new ArrayList<>();
        for (int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new int[][]{
                    {num, 0, 0},
                    {gold, silver, bronze}
            });
        }

        List<int[][]> result = list.stream()
                .sorted((o1, o2) -> {
                    if (o1[1][0] != o2[1][0]) {
                        return o2[1][0] - o1[1][0];
                    }
                    if (o1[1][1] != o2[1][1]) {
                        return o2[1][1] - o1[1][1];
                    }
                    return o2[1][2] - o1[1][2];
                }).collect(Collectors.toList());

        eval(result, K);
    }

    private static void eval(List<int[][]> result, int K) {
        int cnt = 1;
        int prevGold = -1, prevSilver = -1, prevBronze = -1;
        int rank = 1;
        for (int i = 0; i < result.size(); i++) {
            int[][] current = result.get(i);
            int num = current[0][0];
            int gold = current[1][0];
            int silver = current[1][1];
            int bronze = current[1][2];
            if (gold != prevGold || silver != prevSilver || bronze != prevBronze) {
                rank = cnt;
                prevGold = gold;
                prevSilver = silver;
                prevBronze = bronze;
            }
            if (num == K) {
                System.out.println(rank);
                break;
            }
            cnt++;
        }
    }
}