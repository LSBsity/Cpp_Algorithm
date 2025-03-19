import java.util.*;

class Solution {
    
    static class Element {
        int value;
        boolean isTarget;
        
        public Element(int value, boolean isTarget) {
            this.value = value;
            this.isTarget = isTarget;
        }
        
        
    }
    public int solution(int[] p, int l) {
        List<Element> list = new ArrayList<>();
        
        for (int i = 0; i < p.length; i++) {
            list.add(new Element(p[i], l == i ? true : false));
        }
        
        int count = 0;
        while (true) {
            Element target = list.get(0);
            boolean check = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).value > target.value) {
                    list.add(target);
                    list.remove(0);
                    check = false;
                    break;
                }
            }
            
            if (check) {
                count++;
                list.remove(0);
                if (target.isTarget) {
                    return count;
                }
            }
            
            
        }

    }
}