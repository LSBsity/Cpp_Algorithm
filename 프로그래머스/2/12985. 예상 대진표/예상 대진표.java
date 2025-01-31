class Solution {

    public int solution(int n, int a, int b) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        arr[a - 1] = Integer.MAX_VALUE;
        arr[b - 1] = Integer.MAX_VALUE;

        int round = 0;
        while (true) {
            round++;
            if (check(arr)) {
                break;
            }
            int[] temp = new int[n /= 2];
            for (int i = 0, idx = 0; i < temp.length; i++, idx += 2) {
                temp[i] = Math.max(arr[idx], arr[idx + 1]);
            }
            arr = temp;
        }
        return round;
    }

    private boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }
}