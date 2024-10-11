import java.util.function.IntPredicate;

class Solution {
    public int solution(int a, int b) {
        IntPredicate isOdd = x -> x % 2 == 1;
        if (isOdd.test(a) && isOdd.test(b)) {
            return a * a + b * b;
        } else if (isOdd.test(a) || isOdd.test(b)) {
            return 2 * (a + b);
        } else {
            return Math.abs(a - b);
        }
    }
}