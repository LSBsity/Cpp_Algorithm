class Solution {
    public int solution(int price) {
        double a = 0;
        if (price >= 500_000) {
            a = 0.2;
        } else if (price >= 300_000) {
            a = 0.1;
        } else if (price >= 100_000) {
            a = 0.05;
        }
        return (int) (price * (1.0 - a));
    }
}