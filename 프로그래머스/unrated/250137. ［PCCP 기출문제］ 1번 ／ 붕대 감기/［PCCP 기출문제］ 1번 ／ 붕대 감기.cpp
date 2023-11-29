#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int end = attacks[attacks.size() - 1][0];
    int maxHealth = health;
    int j = 0;
    int stroke = 0;
    for (int i = 1; i <= end; i++) {
        if (attacks[j][0] == i && j < attacks.size()) {
            health -= attacks[j++][1];
            stroke = 0;
            if (health <= 0)
                return -1;
        } else {
            health += bandage[1];
            stroke++;
            if (stroke == bandage[0]) {
                health += bandage[2];
                stroke = 0;
            }
            if (health > maxHealth)
                health = maxHealth;
        }
    }
    
    return health;
}