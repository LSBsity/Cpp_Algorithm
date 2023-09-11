#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string str)
{
    for (int i = 0; i < str.length(); i++)
        if (str[i] >= 'A' && str[i] <= 'Z')
            str[i] = tolower(str[i]);

    for (int i = 0; i < str.length();)
    {
        if ((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= '0' && str[i] <= '9') || str[i] == '-' || str[i] == '_' || str[i] == '.')
        {
            i++;
            continue;
        }
        str.erase(str.begin() + i);
    }

    for (int i = 1; i < str.length();)
    {
        if (str[i] == '.' && str[i - 1] == '.')
        {
            str.erase(str.begin() + i);
            continue;
        }
        else
            i++;
    }

    if (str.front() == '.')
        str.erase(str.begin());

    if (str.back() == '.')
        str.erase(str.end() - 1);

    if (str.length() == 0)
        str = "a";

    if (str.length() >= 16)
    {
        while (str.length() != 15)
            str.erase(str.begin() + 15);
    }

    if (str.back() == '.')
        str.erase(str.end() - 1);

    if (str.length() <= 2)
    {
        while (str.length() != 3)
            str += str.back();
    }

    return str;
}