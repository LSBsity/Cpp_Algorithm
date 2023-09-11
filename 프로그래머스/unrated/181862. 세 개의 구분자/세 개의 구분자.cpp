#include <string>
#include <vector>
#include <sstream>
using namespace std;

vector<string> solution(string myStr) {
    vector<string> answer;
    int count = 0;
    for (int i = 0; i < myStr.size(); i++)
    {
        if (myStr[i] == 'a' || myStr[i] == 'b' || myStr[i] == 'c')
        {
            myStr[i] = ' ';
            count++;
        }
    }
    if (count == myStr.size())
    {
        answer.push_back("EMPTY");
        return answer;
    }
    stringstream ss;
    ss.str(myStr);
    string word;
    while (ss >> word)
    {
        answer.push_back(word);
    }
    return answer;
}