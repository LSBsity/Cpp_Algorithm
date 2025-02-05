class Solution {
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (check(sum)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean check(int num) {
        if (num == 1) return false;
        if (num == 2) return true;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}