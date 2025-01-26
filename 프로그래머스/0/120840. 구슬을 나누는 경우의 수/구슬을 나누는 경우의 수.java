import java.math.BigInteger;

class Solution {

    public BigInteger fac(int i) {
        if (i == 1 || i == 0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(i).multiply(fac(i - 1));
    }

    public BigInteger solution(int balls, int share) {
        return fac(balls).divide(fac(share).multiply(fac(balls - share)));
    }
}