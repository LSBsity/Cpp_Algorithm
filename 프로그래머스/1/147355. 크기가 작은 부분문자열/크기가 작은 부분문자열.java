import java.math.BigInteger;

class Solution {
    public int solution(String t, String p) {
        int count = 0;
        BigInteger pValue = BigInteger.valueOf(Long.parseLong(p));

        for (int i = 0; i <= t.length() - p.length(); i++) {
            BigInteger tValue = BigInteger.valueOf(Long.parseLong(t.substring(i, i + p.length())));
            if (tValue.compareTo(pValue) != 1) count++;
        }

        return count;
    }
}