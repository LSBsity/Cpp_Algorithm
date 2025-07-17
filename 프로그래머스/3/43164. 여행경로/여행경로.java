import java.util.*;

class Solution {
    static class Edge {
        int to;
        boolean used;
        Edge(int to) {
            this.to = to;
            this.used = false;
        }
    }

    static Map<String, Integer> strMap = new HashMap<>();
    static Map<Integer, String> intMap = new HashMap<>();
    static List<String> path = new ArrayList<>();
    static List<String> result = null;
    
    private void dfs(List<Edge>[] g, int from, int ticketCount) {
        path.add(intMap.get(from));
        
        if (path.size() == ticketCount + 1) {
            if (result == null || String.join("", path).compareTo(String.join("", result)) < 0) {
                result = new ArrayList<>(path);
            }
            path.remove(path.size() - 1);
            return;
        }
        
        for (Edge edge : g[from]) {
            if (!edge.used) {
                edge.used = true;
                dfs(g, edge.to, ticketCount);
                edge.used = false;
            }
        }
        
        path.remove(path.size() - 1);
    }
    
    public String[] solution(String[][] tickets) {
        int airportNum = 0;
        
        for (String[] ticket : tickets) {
            if (!strMap.containsKey(ticket[0])) {
                strMap.put(ticket[0], airportNum);
                intMap.put(airportNum++, ticket[0]);
            }
            if (!strMap.containsKey(ticket[1])) {
                strMap.put(ticket[1], airportNum);
                intMap.put(airportNum++, ticket[1]);
            }
        }

        List<Edge>[] g = new ArrayList[airportNum];
        for (int i = 0; i < airportNum; i++) g[i] = new ArrayList<>();

        for (String[] ticket : tickets) {
            int from = strMap.get(ticket[0]);
            int to = strMap.get(ticket[1]);
            g[from].add(new Edge(to));
        }

        for (List<Edge> edges : g) {
            edges.sort(Comparator.comparingInt(
                e -> intMap.get(e.to).compareTo(intMap.get(fromIndexOfEdgeList(g, edges)))
            ));
        }

        dfs(g, strMap.get("ICN"), tickets.length);
        return result.toArray(new String[0]);
    }

    private int fromIndexOfEdgeList(List<Edge>[] g, List<Edge> targetList) {
        for (int i = 0; i < g.length; i++) {
            if (g[i] == targetList) return i;
        }
        return -1;
    }
}
