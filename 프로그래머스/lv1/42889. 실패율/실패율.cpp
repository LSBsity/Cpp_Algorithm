#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(const pair<int, double>& a, const pair<int, double>& b)
{
    if (a.second == b.second) return a.first < b.first;
    return a.second > b.second;
}
vector<int> solution(int N, vector<int> stages)
{
    vector<int> answer;
    vector<pair<int, double>> ans;

    for (int i = 1; i <= N; i++)
    {
        double per = 0;
        double challengers = 0;
        double nonClears = 0;
        for (int j = 0; j < stages.size(); j++)
        {
            if (stages[j] >= i) challengers++;
            if (stages[j] == i) nonClears++;
        }
        per = nonClears / challengers;
        if (challengers == 0)
            per = 0;
        ans.push_back(make_pair(i, per));
    }
    sort(ans.begin(), ans.end(), compare);

    for (int i = 0; i < N; i++) 
        answer.push_back(ans[i].first);
        
    return answer;
}
