class Solution {

    public int solution(int[] numbers, int k) {
        int idx = 0;
        while (--k > 0) {
            idx += 2;
            idx %= numbers.length;
        }
        return numbers[idx];
    }
}