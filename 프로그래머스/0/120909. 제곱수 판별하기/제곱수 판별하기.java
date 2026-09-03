class Solution {
    public int solution(int n) {
        double val = Math.sqrt(n);
        return val == Math.floor(val) ? 1 : 2;
    }
}