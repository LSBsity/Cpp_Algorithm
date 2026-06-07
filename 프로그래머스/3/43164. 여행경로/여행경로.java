import java.util.*;

class Solution {
    
    static Map<String, List<String>> graph = new HashMap<>();
    static List<String> path = new ArrayList<>();
    static int size;
    
    public String[] solution(String[][] tickets) {
        size = tickets.length;
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }
        
        for (List<String> ticket : graph.values()) {
            Collections.sort(ticket);
        }
        
        path.add("ICN");
        go("ICN");
        
        return path.toArray(new String[0]);
    }
    
    private static boolean go(String cur) {
        if (path.size() == size + 1) {
            return true;
        }
        
        List<String> nexts = graph.get(cur);
        if (nexts == null) return false;
        
        for (int i = 0; i < nexts.size(); i++) {
            String next = nexts.remove(i);
            path.add(next);
            
            if (go(next)) return true;
            
            nexts.add(i, next);
            path.remove(path.size() - 1);
        }
        
        return false;
    }
}