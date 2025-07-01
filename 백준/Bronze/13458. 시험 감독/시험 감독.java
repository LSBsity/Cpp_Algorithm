import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        int B, C;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int t = 0; t < T; t++) {
            arr[t] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long sum = T;
        for (int i = 0; i < T; i++) {
            int rem = arr[i] - B;
            if (rem > 0) {
                sum += rem / C;
                if (rem % C != 0) {
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
