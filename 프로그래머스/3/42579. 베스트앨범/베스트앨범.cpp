#include <string>
#include <vector>
#include <map>
#include <set>
#include <algorithm>
using namespace std;

struct Song {
    int num;
    int plays;
    Song(int num, int plays) : num(num), plays(plays) {}

    bool operator<(const Song& s) const { return plays > s.plays; }
};

int oper(pair<string, pair<int, multiset<Song>>> s1,
         pair<string, pair<int, multiset<Song>>> s2) {
    return s1.second.first > s2.second.first;
}

vector<int> solution(vector<string> g, vector<int> p) {
    vector<int> ans;

    map<string, pair<int, multiset<Song>>> m;

    for (int i = 0; i < p.size(); i++) {
        m[g[i]].first += p[i];
        m[g[i]].second.insert(Song(i, p[i]));
    }

    vector<pair<string, pair<int, multiset<Song>>>> v;

    for (auto i : m)
        v.push_back({i.first, {i.second.first, i.second.second}});

    sort(v.begin(), v.end(), oper);

    for (auto i : v) {
        auto k = m[i.first].second;
        int cnt = 0;
        for (auto l : k) {
            ans.push_back(l.num);
            cnt++;
            if (cnt > 1) break;
        }
    }
    return ans;
}