import java.util.Arrays;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = Arrays.stream(myStr.split("[abc]"))
                .filter(i -> !i.isEmpty())
                .toArray(String[]::new);
        return arr.length != 0 ? arr : new String[]{"EMPTY"};
    }
}