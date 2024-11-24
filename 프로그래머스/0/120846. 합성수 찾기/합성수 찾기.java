import java.util.stream.IntStream;

class Solution {
    public static boolean go(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
            if (count >= 3) return true;
        }
        return false;
    }

    public int solution(int n) {
        return (int) IntStream.rangeClosed(4, n)
                .filter(Solution::go)
                .count();
    }
}