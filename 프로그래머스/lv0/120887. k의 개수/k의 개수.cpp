#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int c)
{
    int answer = 0;
    string z = "";
    for (int i = a; i <= b; i++)
    {
        z.append(to_string(i));
    }

    for (int i = 0; i < z.length(); i++)
    {   string d = "";
        d.append(to_string(c));
        if (z[i] == d[0])
            answer++;
        d.clear();    
    }

    return answer;
}