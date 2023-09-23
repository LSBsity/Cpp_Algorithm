#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    for (int i = 0; i < targets.size(); i++) {
        string temp = targets[i];
        int sum = 0, sign = 0;
        for (int j = 0; j < temp.size(); j++) {
            vector<int> v;
            int check = 0;
            for (int k = 0; k < keymap.size(); k++) {
                int idx = keymap[k].find(temp[j]);
                if (idx != string::npos)
                    v.push_back(idx + 1);
                else
                    check++;
            }
            if (check != keymap.size())
                sum += *min_element(v.begin(), v.end());
            else {
                sign = 1;
                break;
            }
        }
        if (sum && !sign)
            answer.push_back(sum);
        else
            answer.push_back(-1);
    }
    return answer;
}