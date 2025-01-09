import java.util.Arrays;

class Solution {
    private static void colatz(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] /= 2;
            } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                arr[i] *= 2;
                arr[i]++;
            }
        }
    }

    private static boolean check(final int[] arr, final int[] newArr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != newArr[i]) return false;
        }
        return true;
    }

    public int solution(int[] arr) {
        int answer = 0;
        while (true) {
            int[] newArr = Arrays.copyOf(arr, arr.length);

            colatz(arr);

            if (check(arr, newArr)) return answer;
            answer++;
        }
    }
}