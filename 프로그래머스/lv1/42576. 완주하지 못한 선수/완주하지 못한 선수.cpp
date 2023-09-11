#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> arr1, vector<string> arr2)
{
    if (arr2.size() == 0)
        return arr1[0];
    
    string answer = "";
    sort(arr1.begin(), arr1.end());
    sort(arr2.begin(), arr2.end());
    
    for (int i = 0; i < arr1.size(); i++)
    {
        if (arr1[i] != arr2[i])
        {
            answer += arr1[i];
            break;
        }
    }
    return answer;
}