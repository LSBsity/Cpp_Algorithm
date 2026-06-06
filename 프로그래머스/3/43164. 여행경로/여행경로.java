import java.util.*;

class Solution {
    static Map<String, List<String>> graph = new HashMap<>();
    static List<String> path = new ArrayList<>();
    static int total;

    public String[] solution(String[][] tickets) {
        total = tickets.length;
        for (String[] t : tickets) {
            graph.putIfAbsent(t[0], new ArrayList<>());
            graph.get(t[0]).add(t[1]);
        }
        for (List<String> v : graph.values()) Collections.sort(v);

        path.add("ICN");
        go("ICN");
        return path.toArray(new String[0]);
    }

    static boolean go(String cur) {
        if (path.size() == total + 1) return true;

        List<String> nexts = graph.get(cur);
        if (nexts == null) return false;

        for (int i = 0; i < nexts.size(); i++) {
            String next = nexts.remove(i);   // 티켓 한 장 사용
            path.add(next);

            if (go(next)) return true;

            path.remove(path.size() - 1);    // 백트래킹
            nexts.add(i, next);              // 티켓 도로 넣기
        }
        return false;
    }
}