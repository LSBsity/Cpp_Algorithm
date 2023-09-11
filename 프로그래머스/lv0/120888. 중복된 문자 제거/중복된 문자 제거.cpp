#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string my_string)
{
    string a = my_string;

    for (int i = 0; i < a.length(); i++)
        a.erase(remove(a.begin() + i + 1, a.end(), a[i]), a.end());

    return a;
}