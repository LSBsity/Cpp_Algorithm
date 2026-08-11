class Solution {
    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w, h));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}