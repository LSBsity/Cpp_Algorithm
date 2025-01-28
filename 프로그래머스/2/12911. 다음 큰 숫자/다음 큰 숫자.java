class Solution {

    public int counts(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int solution(int n) {
        int initCount = this.counts(Integer.toBinaryString(n));

        while (true) {
            String str = Integer.toBinaryString(++n);
            if (initCount == this.counts(str)) {
                return Integer.parseInt(str, 2);
            }
        }
    }
}
