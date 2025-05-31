import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) break;
            int[] arr = new int[]{a, b, c};
            Arrays.sort(arr);
            if (arr[2] >= arr[0] + arr[1]) {
                System.out.println("Invalid");
                continue;
            }
            if (a == b && b == c) {
                System.out.println("Equilateral");
                continue;
            }
            if (arr[0] == arr[1] || arr[1] == arr[2]) {
                System.out.println("Isosceles");
                continue;
            }
            System.out.println("Scalene");
        }
    }
}


