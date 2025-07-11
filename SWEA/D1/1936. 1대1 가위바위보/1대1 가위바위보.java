import java.io.*;
import java.util.*;

class Solution {

    static boolean[][] arr = new boolean[][]{
            {false, false, false},
            {false, false, false, true},
            {false, true, false, false},
            {false, false, true, false}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean result = arr[a][b];
        System.out.println(result ? "A" : "B");
    }
}
