#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int m, int c) {
    vector<string> v;
    
    int i = 0;
    while(i < my_string.size())
    {
        string temp = "";
        temp = my_string.substr(i, m);
        v.push_back(temp);
        i += m;
    }

    string answer = "";
    for (int i = 0; i < v.size(); i++)
        answer += v[i][c-1];
    
    return answer;
}