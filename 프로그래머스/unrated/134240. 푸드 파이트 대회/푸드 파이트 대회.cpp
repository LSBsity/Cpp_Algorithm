#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> food)
{
    string answer = "";
    string temp = "";
    int len = 0;
    for (int i = 1; i < food.size(); i++)
    {
        len = food[i] / 2;
        if (len >= 1)
        {
            int z = 0;
            while (z < len)
            {
                temp += to_string(i);
                z++;
            }
        }
    }
    answer += temp;
    reverse(temp.begin(), temp.end());
    answer += '0';
    answer += temp;

    return answer;
}