import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, 0, new HashSet<>());
        return result.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, int idx, Set<String> current) {
        if (idx == banned_id.length) {
            result.add(new HashSet<>(current));
            return;
        }
        
        for (String id : user_id) {
            if (!current.contains(id) && isMatch(banned_id[idx], id)) {
                current.add(id);
                dfs(user_id, banned_id, idx + 1, current);
                current.remove(id);
            }
        }
    }
    
    private boolean isMatch(String ban, String id) {
        if (ban.length() != id.length()) return false;
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != id.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}