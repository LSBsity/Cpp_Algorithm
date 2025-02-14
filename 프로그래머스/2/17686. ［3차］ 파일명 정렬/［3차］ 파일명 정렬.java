import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .sorted(Comparator.comparing(this::getHead, String.CASE_INSENSITIVE_ORDER)
                        .thenComparingInt(this::getNumber))
                .toArray(String[]::new);
    }

    private String getHead(String file) {
        return file.split("[0-9]")[0];
    }

    private int getNumber(String file) {
        StringBuilder numberPart = new StringBuilder();
        boolean foundDigit = false;

        for (char c : file.toCharArray()) {
            if (Character.isDigit(c)) {
                numberPart.append(c);
                foundDigit = true;
            } else if (foundDigit) {
                break;
            }
        }
        return Integer.parseInt(numberPart.toString());
    }
}