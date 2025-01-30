class Solution {

    public String solution(String polynomial) {
        String[] split = polynomial.split(" \\+ ");

        int count = 0;
        int constCount = 0;
        for (String str : split) {
            if (str.endsWith("x")) {
                if (!str.startsWith("x")) {
                    String subs = str.substring(0, str.length() - 1);
                    count += Integer.parseInt(subs);
                } else {
                    count++;
                }
            } else {
                constCount += Integer.parseInt(str);
            }
        }

        if (count == 0) {
            return String.valueOf(constCount);
        } else {
            if (count == 1) {
                if (constCount != 0) {
                    return String.format("x + %d", constCount);
                } else {
                    return String.format("x");
                }
            } else {
                if (constCount != 0) {
                    return String.format("%dx + %d", count, constCount);
                } else {
                    return String.format("%dx", count);
                }
            }
        }
    }
}