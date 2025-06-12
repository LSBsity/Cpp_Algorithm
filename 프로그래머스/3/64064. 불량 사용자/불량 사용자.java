import java.util.*;

class Solution {
    
    Set<Set<String>> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        go(user_id, banned_id, 0, new HashSet<>());
        return set.size();
    }
    
    private void go(String[] user_id, String[] banned_id, int idx, Set<String> current) {
        if (idx == banned_id.length) {
            set.add(new HashSet<>(current));
            return;
        }
        
        for (var id : user_id) {
            if (!current.contains(id) && isMatch(banned_id[idx], id)) {
                current.add(id);
                this.go(user_id, banned_id, idx + 1, current);
                current.remove(id); 
            }
        }
    }
    
    public boolean isMatch(String ban, String id) {
        if (ban.length() != id.length()) return false;
        for (int i = 0; i < ban.length(); i++) {
            char c = ban.charAt(i);
            if (c != '*' && c != id.charAt(i)) return false;
        }
        return true;
    }
}