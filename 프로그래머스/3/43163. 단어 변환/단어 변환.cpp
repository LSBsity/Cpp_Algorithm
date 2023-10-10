#include <string>
#include <vector>
#include <queue>
#include <unordered_set>
#include <algorithm>

using namespace std;

bool v[50];

int check(string a, string b) {
    int count = 0;
    for (int i = 0; i < a.size(); i++)
        if (a[i] != b[i]) count++;
    return count == 1 ? 1 : 0;
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    queue<pair<string, int>> q;
    int num;

    q.push(make_pair(begin, 0));
    while (!q.empty()) {
        string tmp = q.front().first;
        int tmpCnt = q.front().second;
        q.pop();

        if (tmp == target) return tmpCnt;

        for (int i = 0; i < words.size(); i++) {
            if (v[i]) continue;

            if (check(tmp, words[i])) {
                v[i] = 1;
                q.push(make_pair(words[i], tmpCnt + 1));
            }
        }
    }

    return 0;
}