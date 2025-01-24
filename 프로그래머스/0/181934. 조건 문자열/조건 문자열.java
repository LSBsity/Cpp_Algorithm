import java.util.function.BiPredicate;

class Solution {
    BiPredicate<Integer, Integer> gt = (i, j) -> i > j;
    BiPredicate<Integer, Integer> ge = (i, j) -> i >= j;
    BiPredicate<Integer, Integer> lt = (i, j) -> i < j;
    BiPredicate<Integer, Integer> le = (i, j) -> i <= j;

    public int solution(String ineq, String eq, int n, int m) {
        return test(ineq, eq, n, m);
    }

    private int test(String ineq, String eq, int n, int m) {
        int result = 0;
        if (ineq.equals("<")) {
            if (eq.equals("=")) {
                result = le.test(n, m) ? 1 : 0;
            } else {
                result = lt.test(n, m) ? 1 : 0;
            }
        } else if (ineq.equals(">")) {
            if (eq.equals("=")) {
                result = ge.test(n, m) ? 1 : 0;
            } else {
                result = gt.test(n, m) ? 1 : 0;
            }
        }
        return result;
    }
}