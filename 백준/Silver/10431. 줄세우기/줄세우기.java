import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = 0, j; i < 20; i++) {
                int val = Integer.parseInt(st.nextToken());
                for (j = 0; j < list.size(); j++) {
                    if (list.get(j) > val) {
                        cnt += list.size() - j;
                        break;
                    }
                }
                list.add(j, val);
            }
            System.out.println(num + " " + cnt);
        }

    }
}