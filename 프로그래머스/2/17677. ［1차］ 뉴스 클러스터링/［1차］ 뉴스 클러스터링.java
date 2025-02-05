import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = go(str1);
        List<String> list2 = go(str2);

        list1.sort(String::compareTo);
        list2.sort(String::compareTo);

        List<String> list2Temp = new ArrayList<>(List.copyOf(list2));
        List<String> union = new ArrayList<>(List.copyOf(list2));
        List<String> intersection = new ArrayList<>();

        for (String str : list1) {
            if (list2.contains(str)) {
                list2.remove(str);
                intersection.add(str);
            }
            if (!list2Temp.contains(str)) {
                union.add(str);
            } else {
                list2Temp.remove(str);
            }
        }

        if (union.isEmpty()) return 65536;
        return (int) (((double) intersection.size() / union.size()) * 65536);

    }

    private List<String> go(String str) {
        List<String> list = new ArrayList<>();

        String converted = str.toLowerCase();
        for (int i = 0; i < converted.length() - 1; i++) {
            String subs = converted.substring(i, i + 2);
            boolean check = false;
            for (char c : subs.toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    check = true;
                    break;
                }

            }
            if (!check) {
                list.add(subs);
            }
        }
        return list;
    }
}
