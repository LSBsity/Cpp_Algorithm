#include <string>
#include <vector>
#include <queue>
#include <unordered_set>
#include <algorithm>

using namespace std;

int solution(string begin, string target, vector<string> w) {

    unordered_set<string> s(w.begin(), w.end());
    
    if (s.find(target) == s.end()) return 0;

    queue<string> q;
    q.push(begin);
    int cnt = 0;

    while (!q.empty()) {
        int size = q.size();
        while (size--) {
            string cur = q.front();
            q.pop();

            if (cur == target) return cnt;

            for (int i = 0; i < cur.size(); i++) {
                char origin = cur[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == origin) continue;
                    cur[i] = c;
                    if (s.find(cur) != s.end()) {
                        q.push(cur);
                        s.erase(cur);  
                    }
                }
                cur[i] = origin;  
            }
        }
        cnt++;
    }

    return 0; 
}