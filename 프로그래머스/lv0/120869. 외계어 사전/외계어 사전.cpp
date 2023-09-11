#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<string> spell, vector<string> dic)
{
    string arr3 = "";
    sort(spell.begin(), spell.end());

    for (int i = 0; i < dic.size(); i++)
        sort(dic[i].begin(), dic[i].end());

    for (int i = 0; i < spell.size(); i++)
        arr3.append(spell[i]);
    
    for (int i = 0; i < dic.size(); i++)
    {
        if (dic[i] == arr3)
            return 1;
    }
          
    return 2;
}