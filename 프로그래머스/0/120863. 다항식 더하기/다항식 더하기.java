import java.util.*;

class Solution {
    public String solution(String polynomial) {
        int xVal = 0, val = 0;
        String[] split = polynomial.split(" \\+ ");
        
        for (String token : split) {
            if (token.endsWith("x")) {
                String coef = token.substring(0, token.length() - 1);
                xVal += coef.isEmpty() ? 1 : Integer.parseInt(coef);  
            } else {
                val += Integer.parseInt(token);
            }
        }
        
        String xPart = xVal == 1 ? "x" : xVal + "x";
        if (xVal == 0) return String.valueOf(val);
        if (val == 0) return xPart;
        return xPart + " + " + val;
    }
}