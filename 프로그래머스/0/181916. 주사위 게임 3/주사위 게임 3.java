import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int a, int b, int c, int d) {
        List<Integer> list = Arrays.asList(a, b, c, d);
        list.sort(Comparator.naturalOrder());

        a = list.get(0);
        b = list.get(1);
        c = list.get(2);
        d = list.get(3);

        if ((a == b) && (b == c) && (c == d)) {
            return a * 1111;
        }

        if ((a == b && b == c)) {
            return (int) Math.pow((10 * a + d), 2);
        } else if ((b == c && c == d)) {
            return (int) Math.pow((10 * d + a), 2);
        }

        if (a == b && c == d) {
            return (a + c) * Math.abs(a - c);
        } else if (a == b) {
            return c * d;
        } else if (b == c) {
            return a * d;
        } else if (c == d) {
            return a * b;
        }

        return a;
    }
}