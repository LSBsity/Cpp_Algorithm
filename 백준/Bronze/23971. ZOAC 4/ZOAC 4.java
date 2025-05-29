import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int r = N + 1;
        int c = M + 1;

        double row = Math.ceil((double) H / r);
        double col = Math.ceil((double) W / c);

        System.out.println((int)(row * col));

        br.close();
    }
}