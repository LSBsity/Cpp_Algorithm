#include<string>
#include <iostream>
#include <vector>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    vector<char> v;

    if (s.front() == ')')
        return false;
    else if (s.back() == '(')
        return false;
    

    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] == '(')
            v.push_back(s[i]);
        else if (v.size() != 0 && s[i] == ')')
            v.pop_back();
        else if (v.size() == 0 && s[i] == ')')
            return false;
    }
    
    return v.size() == 0 ? true : false;
}