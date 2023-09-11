#include <string>
#include <vector>
#include <algorithm>

using namespace std;


vector<int> solution(vector<int> arr)
{
    vector<int> answer;

    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] != *min_element(arr.begin(), arr.end()))
            answer.push_back(arr[i]);
    }
    
    return answer.size() == 1 ? vector<int>(1, -1) : answer;
}