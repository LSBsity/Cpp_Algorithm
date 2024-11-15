import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        BigInteger unsignedLongLong = new BigInteger(number);
        BigInteger remainder = unsignedLongLong.remainder(new BigInteger("9"));
        return remainder.intValue();
    }
}