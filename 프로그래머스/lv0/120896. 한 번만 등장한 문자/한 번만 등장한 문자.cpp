#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s)
{
    string answer = "";
    string temp = "";
    string word = s;
    for (int i = 0; i < s.length(); i++)
    {
        temp = s[i];
        word.erase(word.begin() + i);
        bool flag = false;
        for (int j = 0; j < s.length(); j++)
        {
            if (temp[0] == word[j])
                flag = true;
        }
        if (flag == false)
            answer.append(temp);
        word = s;
    }

    sort(answer.begin(), answer.end());

    return answer;
}