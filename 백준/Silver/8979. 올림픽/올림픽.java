import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for (int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int val = 3 * Integer.parseInt(st.nextToken()) + 2 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            list.add(new int[]{num, val});
        }

        List<int[]> result = list.stream()
                .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                .collect(Collectors.toList());
        
        for (int i = 0, cnt = 0, last = -1; i < result.size(); i++) {
            if (result.get(i)[1] != last) {
                cnt++;
                last = result.get(i)[1];
            }
            if (result.get(i)[0] == K) {
                System.out.println(cnt);
            }
        }
    }
}