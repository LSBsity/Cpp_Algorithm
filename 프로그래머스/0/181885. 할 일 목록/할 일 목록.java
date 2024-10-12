import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, finished.length)
                .filter(i -> finished[i] == false)
                .mapToObj(i -> todo_list[i])
                .toArray(String[]::new);
    }
}