#include <string>
#include <vector>

using namespace std;


vector<string> solution(string my_str, int n)
{
    vector<string> answer;
    int size = 0;

    if (my_str.length() % n == 0)
        size = my_str.length() / n;
    else
        size = (my_str.length() / n)+1;
    
    int z = 0;
    for (int i = 0; i < size; i++)
    {
        answer.push_back(my_str.substr(z, n));
        z += n;
    }

    return answer;
}