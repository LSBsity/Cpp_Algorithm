#include <string>
#include <vector>

using namespace std;

bool check(string str)
{
    for (int i = 0; i < str.size(); i++)
        if (str[i] != ' ')
            return 0;
    return 1;
}

int solution(vector<string> arr)
{
    int answer = 0;
    vector<string> v = {"aya", "ye", "woo", "ma"};

    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = 0; j < 4; j++)
        {
            int found = arr[i].find(v[j]);
            if (found != string::npos)
            {
                arr[i].erase(found, v[j].length());
                arr[i].insert(found, " ");
            }
        }
        if (check(arr[i]))
            answer++;
    }
    return answer;
}