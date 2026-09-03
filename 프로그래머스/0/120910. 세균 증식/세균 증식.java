class Solution {
    public int solution(int n, int t) {
        while (--t >= 0) {
            n = n * 2;
        }
        return n;
    }
}