class Solution {
    public int solution(int[] arr) {
        int even = 0, odd = 0;

        for (int i : arr) {
            if (i % 2 == 0) {
                even *= 10;
                even += i;
            } else {
                odd *= 10;
                odd += i;
            }
        }
        
        return even + odd;
    }
}