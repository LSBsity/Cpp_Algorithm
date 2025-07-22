import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list.add(arr[i]);
        }
        List<Integer> distinct = list.stream().sorted().distinct().collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < distinct.size(); i++) {
            map.put(distinct.get(i), i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }

        System.out.println(sb);
    }
}
