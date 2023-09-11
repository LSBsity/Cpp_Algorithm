#include <string>
#include <vector>

using namespace std;

string solution(int age)
{
    string age1 = "";
    string answer = "";
    age1 = to_string(age);
    
    for (const auto e : age1)
        answer.push_back(e + 49);

    return answer;
}