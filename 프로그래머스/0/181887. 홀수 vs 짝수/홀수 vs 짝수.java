class Solution {
    public int solution(int[] arr) {
        int even = 0, odd = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (i % 2 == 1) odd += arr[i - 1];
            else even += arr[i - 1];
        }
        return Math.max(even, odd);
    }
}