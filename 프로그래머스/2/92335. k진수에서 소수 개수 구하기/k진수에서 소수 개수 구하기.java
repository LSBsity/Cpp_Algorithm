class Solution {
    public int solution(int n, int k) {
        int count = 0;

        for (String s : Integer.toString(n, k).split("0")) {
            if (s.isEmpty()) continue;
            count = this.check(s) ? count + 1 : count;
        }

        return count;
    }

    private boolean check(String str) {
        if (str == null || str.isEmpty()) return false;

        long value = Long.parseLong(str);
        if (value == 1) return false;
        if (value == 2) return true;

        for (int i = 2; i <= Math.sqrt((double) value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}