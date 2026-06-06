import java.util.*;

class Solution {
    static Map<String, List<String>> graph = new HashMap<>();
    static boolean[] used;       // 각 티켓 사용 여부
    static String[][] tickets;
    static List<String> path = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        Solution.tickets = tickets;
        used = new boolean[tickets.length];

        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new ArrayList<>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        
        for (List<String> dests : graph.values()) {
            Collections.sort(dests);
        }

        path.add("ICN");
        go("ICN");
        return path.toArray(new String[0]);
    }

    private static boolean go(String start) {
        if (path.size() == tickets.length + 1) return true;

        if (!graph.containsKey(start)) return false;

        for (String next : graph.get(start)) {
            for (int i = 0; i < tickets.length; i++) {
                if (used[i]) continue;
                if (!tickets[i][0].equals(start) || !tickets[i][1].equals(next)) continue;

                used[i] = true;
                path.add(next);

                if (go(next)) return true; 
                
                used[i] = false;          
                path.remove(path.size() - 1);
                break; 
            }
        }
        return false;
    }
}