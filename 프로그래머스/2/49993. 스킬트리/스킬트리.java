import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String skills, String[] skill_trees) {
        int answer = skill_trees.length;
        Map<Character, String> requiredSkillMap = new HashMap<>();
        Set<Character> mySkills = new HashSet<>();

        for (int i = 0; i < skills.length(); i++) {
            requiredSkillMap.put(skills.charAt(i), skills.substring(0, i));
        }

        for (String skillTree : skill_trees) {
            boolean flag = true;
            for (int i = 0; i < skillTree.length(); i++) {
                String requiredSkills = requiredSkillMap.get(skillTree.charAt(i));

                if (requiredSkills == null || requiredSkills.isEmpty()) {
                    mySkills.add(skillTree.charAt(i));
                } else {
                    for (int j = 0; j < requiredSkills.length(); j++) {
                        if (!mySkills.contains(requiredSkills.charAt(j))) {
                            flag = false;
                            answer--;
                            break;
                        }
                        mySkills.add(skillTree.charAt(i));
                    }
                }
                if (!flag) {
                    break;
                }
            }
            
            mySkills.clear();
        }

        return answer;
    }
}