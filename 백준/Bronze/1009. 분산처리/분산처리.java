import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = lastComputer(a, b);
            System.out.println(result);
        }
    }

    static int lastComputer(int a, int b) {
        int base = a % 10;
        if (base == 0) return 10;
        int cycle = b % 4 == 0 ? 4 : b % 4;
        int ans = 1;
        for (int i = 0; i < cycle; i++) {
            ans = (ans * base) % 10;
        }
        return ans == 0 ? 10 : ans;
    }
}
