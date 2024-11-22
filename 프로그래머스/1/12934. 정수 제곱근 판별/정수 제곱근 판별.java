class Solution {
    public long solution(long n) {
        double sqrted = Math.sqrt(n);
        if (sqrted * sqrted == n && sqrted % 1 == 0.0) {
            double pow = Math.pow(sqrted + 1, 2);
            return (long) pow;
        }
        return -1;
    }
}