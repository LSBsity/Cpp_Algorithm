import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int size = Integer.parseInt(br.readLine());
            int[] map = new int[size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }
            System.out.printf("#%d %d\n", t + 1, go(map));
        }
    }

    private static int go(int[] arr) {
        int sum = 0;
        for (int i = 2; i < arr.length - 2; i++) {
            int leftMax = Math.max(arr[i - 2], arr[i - 1]);
            int rightMax = Math.max(arr[i + 1], arr[i + 2]);
            if (leftMax < arr[i] && arr[i] > rightMax) {
                sum += arr[i] - Math.max(leftMax, rightMax);
            }
        }
        return sum;
    }

}
