import java.io.*;
import java.util.*;

public class Solution {

    static int count;
    static int max;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = Arrays.stream(st.nextToken().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            count = Integer.parseInt(st.nextToken());
            max = 0;
            visited = new HashSet<>();
            go(array, 0);
            System.out.printf("#%d %d\n", t, max);
        }
    }

    private static void go(int[] array, int depth) {
        if (depth == count) {
            max = Math.max(max, toNumber(array));
            return;
        }

        String state = Arrays.toString(array) + depth;
        if (visited.contains(state)) return;
        visited.add(state);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                swap(array, i, j);
                go(array, depth + 1);
                swap(array, i, j);
            }
        }

        if ((count - depth) % 2 == 1 && !hasDuplicate(array)) {
            swap(array, array.length - 1, array.length - 2);
            go(array, count);
            swap(array, array.length - 1, array.length - 2);
        }
    }

    private static boolean hasDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (!set.add(n)) return true;
        }
        return false;
    }

    private static int toNumber(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result * 10 + array[i];
        }
        return result;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
