#include <string>
#include <vector>

using namespace std;

string solution(string myString, string pat) {
    int index = myString.rfind(pat,myString.size());
    string answer = myString.substr(0,index + pat.size());
    
    return answer;
}