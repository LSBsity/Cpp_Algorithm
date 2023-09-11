#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries)
{
    vector<int> answer;
    for (int i = 0; i < queries.size(); i++)
    {
        vector<int> temp;   
        for (int j = queries[i][0]; j <= queries[i][1]; j++)
            if (arr[j] > queries[i][2])
                temp.push_back(arr[j]);
        
        sort(temp.begin(), temp.end());
    
        if (!temp.size())
            answer.push_back(-1);
        else
            answer.push_back(temp[0]);
    }
    return answer;
}