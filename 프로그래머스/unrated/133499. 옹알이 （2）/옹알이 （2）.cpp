#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool containsOnlySpace(string str) {
    return all_of(str.begin(), str.end(), ::isspace);
}

int solution(vector<string> babbling) {
    int find = 0, npos = 0, answer = 0;
    string v[4] = {"aya", "ye", "woo", "ma"};
    for (int i = 0; i < babbling.size(); i++) {
        string temp = babbling[i];
        int j = 30, k = 0;
        while (j--) {
            npos = temp.find(v[k]);
            if (npos != string::npos) {
                temp.replace(npos, v[k].size(), " ");
                if (temp.find(v[k]) == npos + 1) {
                    break;
                }
            }
            k = (k + 1) % 4;
        }
        if (containsOnlySpace(temp)) answer++;
    }
    return answer;
}