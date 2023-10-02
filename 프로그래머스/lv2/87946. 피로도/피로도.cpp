#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int k, vector<vector<int>> d) {
    int answer = -1;

    vector<int> idx(d.size());

    for (int i = 0; i < d.size(); ++i) {
        idx[i] = i;
    }
    
    do {
        vector<vector<int>> p;
        for (int i = 0; i < d.size(); ++i) {
            p.push_back(d[idx[i]]);
        }
        int fatigue = k, cnt = 0;
        for (int i = 0; i < p.size(); i++) {
            if (fatigue >= p[i][0]) {
                cnt++;
                fatigue -= p[i][1];
            }
        }
        answer = max(answer, cnt);
    } while (next_permutation(idx.begin(), idx.end()));

    return answer;
}