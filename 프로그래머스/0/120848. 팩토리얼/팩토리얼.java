class Solution {

    public int solution(int target) {
        if (target <= 1) return 1;
        int fac = 1, idx = 1;

        int[] arr = new int[1000];
        while (fac < target) {
            fac *= idx;
            arr[idx++] = fac;
        }

        if (arr[idx - 1] == target) return idx - 1;
        return idx - 2;
    }
}