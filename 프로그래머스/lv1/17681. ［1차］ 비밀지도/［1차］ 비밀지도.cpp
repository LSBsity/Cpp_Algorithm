#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2)
{
    vector<string> answer;
    for (int i = 0; i < n; i++)
    {
        arr1[i] = arr1[i] | arr2[i];
        string ans = "";
        for (int j = 0; j < n; j++)
        {
            if (arr1[i] % 2 == 0)
                ans = " " + ans;
            else
                ans = "#" + ans;
            arr1[i] = arr1[i] >> 1;
        }
        answer.push_back(ans);
    }
    return answer;
}