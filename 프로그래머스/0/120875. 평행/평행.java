import java.util.*;

class Solution {
    
    public boolean check(int[] a, int[] b, int[] c, int[] d) {
        double left = (double)(b[1] - a[1]) / (b[0] - a[0]);
        double right = (double)(d[1] - c[1]) / (d[0] - c[0]);
        return Math.abs(left - right) < 1e-9;
    }
    
    public int solution(int[][] dots) {
        // 1,2 - 3,4
        if (this.check(dots[0], dots[1], dots[2], dots[3])) return 1;
        // 1,3 - 2,4
        if (this.check(dots[0], dots[2], dots[1], dots[3])) return 1;
        // 1,4 - 2,3
        if (this.check(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return 0;
    }
}