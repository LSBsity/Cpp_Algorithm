#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;

    map<string, int> nums;

    for (int k = 0; k < orders.size(); k++) {
        string s = orders[k];
        int len = s.size();
        sort(s.begin(), s.end());
        // 조합 생성 부분 수정
        for (int i = 1; i <= len; i++) {
            vector<bool> v(len - i, false);
            v.insert(v.end(), i, true);

            do {
                string temp = "";
                for (int j = 0; j < len; j++) {
                    if (v[j]) temp += s[j];
                }
                if (temp.size() >= 2) nums[temp]++;
            } while (next_permutation(v.begin(), v.end()));
        }
    }

    for (int c : course) {
        vector<pair<string, int>> t;

        // 수정된 부분: 메뉴를 정렬하여 중복을 방지하고, 주문 횟수를 계산
        for (auto it : nums) {
            if (it.first.size() == c && it.second >= 2) {
                t.push_back(it);
            }
        }

        // 정렬 부분 수정
        sort(t.begin(), t.end(), [](const auto &a, const auto &b) {
            return a.second > b.second;
        });

        // 가장 많이 주문된 메뉴 조합을 추가하는 부분 수정
        for (auto i : t) {
            if (i.second == t[0].second) {
                answer.push_back(i.first);
            } else {
                break;
            }
        }
    }

    sort(answer.begin(), answer.end());

    return answer;
}