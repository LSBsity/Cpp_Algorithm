import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] answer = new int[N];
        Deque<Integer> stk = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
                answer[stk.pop()] = arr[i];
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }

        for (var i : answer) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}