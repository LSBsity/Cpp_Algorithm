import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for (String intStr : intStrs) {
            String str = intStr.substring(s, s + l);
            int ints = Integer.parseInt(str);
            if (ints > k) {
                list.add(ints);
            }
        }
        return list;
    }
}