public class Solution {
    public int solution(int storey) {
        int count = 0;

        while (storey != 0) {
            int digit = storey % 10;
            if (digit > 5) {
                storey += 10 - digit;
                count += 10 - digit;
            } else if (digit < 5) {
                storey -= digit;
                count += digit;
            } else { 
                int nextDigit = (storey / 10) % 10;
                if (nextDigit >= 5) {
                    storey += 10 - digit;
                    count += 10 - digit;
                } else {
                    storey -= digit;
                    count += digit;
                }
            }
            storey /= 10;
        }

        return count;
    }
}
