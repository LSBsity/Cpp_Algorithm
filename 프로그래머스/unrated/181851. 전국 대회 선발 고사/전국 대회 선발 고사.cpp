#include <string>
#include <vector>
#include <algorithm>
#include <tuple>
using namespace std;

bool CmpRank(tuple<int, int, bool> v1, tuple<int, int, bool> v2)
{
    return get<1>(v1) <get<1>(v2);
}

int solution(vector<int> rank, vector<bool> attendance) {
    vector<tuple<int, int, bool>> m;
    
    for (int i = 0; i < rank.size(); i++)
        m.push_back(make_tuple(i, rank[i], attendance[i]));
    
    sort(m.begin(), m.end(), CmpRank);
    
    vector<int> ans;
    for (int i = 0; i < m.size(); i++)
        if (get<2>(m[i]))
            ans.push_back(get<0>(m[i]));
    
    return 10000 * ans[0] + 100 * ans[1] + ans[2];
}