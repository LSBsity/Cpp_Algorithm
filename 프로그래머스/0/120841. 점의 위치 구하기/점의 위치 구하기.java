class Solution {
    public int solution(int[] dot) {
        int a = dot[0];
        int b = dot[1];
        
        if (a > 0 && b > 0) return 1;
        if (a < 0 && b > 0) return 2;
        if (a < 0 && b < 0) return 3;
        
        return 4;
    }
}