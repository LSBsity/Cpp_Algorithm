#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(string myString, string pat) {
    int cnt = 0;
    
    for (int i = 0; i < myString.size(); i++)
    {
        int idx = myString.find(pat, i);
        if (idx != string::npos)
        {
            cnt++;
            i = idx;
        }    
    }
    
    
    return cnt;
}