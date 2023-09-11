#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int i = 0;
bool comp(string s1, string s2)
{
    if (s1[i] == s2[i])
        return s1 < s2;
    else
        return s1[i] < s2[i];
}
vector<string> solution(vector<string> strings, int n)
{
    i = n;
    sort(strings.begin(), strings.end(), comp);
    return strings;
}