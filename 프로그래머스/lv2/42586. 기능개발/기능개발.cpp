#include <string>
#include <vector>

using namespace std;


vector<int> solution(vector<int> arr, vector<int> arr2)
{
    vector<int> answer;

    while (arr.size() != 0)
    {
        for (int i = 0; i < arr.size(); i++)
            arr[i] += arr2[i];

        if (arr[0] >= 100)
        {
            int check = 0;
            for (int i = 0; i < arr.size(); i++)
            {
                if (arr[i] >= 100)
                {
                    check++;
                    if (arr[i + 1] < 100)
                        break;
                }
            }
            answer.push_back(check);
            for (int i = 0; i < check; i++)
            {
                arr.erase(arr.begin());
                arr2.erase(arr2.begin());
            }
        }
    }
    return answer;
}