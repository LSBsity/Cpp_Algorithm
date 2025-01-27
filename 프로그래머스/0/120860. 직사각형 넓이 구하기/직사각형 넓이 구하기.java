class Solution {

    public int solution(int[][] dots) {
        int x = Math.max(Math.max(Math.max(dots[0][0], dots[1][0]), dots[2][0]), dots[3][0]);
        int x2 = Math.min(Math.min(Math.min(dots[0][0], dots[1][0]), dots[2][0]), dots[3][0]);
        int y = Math.max(Math.max(Math.max(dots[0][1], dots[1][1]), dots[2][1]), dots[3][1]);
        int y2 = Math.min(Math.min(Math.min(dots[0][1], dots[1][1]), dots[2][1]), dots[3][1]);
        return (x - x2) * (y - y2);
    }
}