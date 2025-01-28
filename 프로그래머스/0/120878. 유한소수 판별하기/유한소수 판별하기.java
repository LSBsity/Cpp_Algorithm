import java.util.ArrayList;
import java.util.List;

class Solution {

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private boolean check(int deno) {
        int start = 2;
        while (deno >= start) {
            if (deno % start == 0) {
                while (deno % start == 0) {
                    deno /= start;
                }
                if (start != 2 && start != 5) {
                    return false;
                }
            }
            start++;
        }
        return true;
    }


    public int solution(int a, int b) {
        return this.check(b / this.gcd(a, b)) ? 1 : 2;
    }
}