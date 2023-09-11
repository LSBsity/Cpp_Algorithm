#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> delete_list) {
    vector<int> answer;
    for (int i = 0; i < arr.size(); i++)
    {
        int sign = 0;
        for (int j = 0; j < delete_list.size(); j++)
        {
            if (arr[i] == delete_list[j])
                sign = 1;
        }
        if (sign == 0)
            answer.push_back(arr[i]);
    }
    
    return answer;
}