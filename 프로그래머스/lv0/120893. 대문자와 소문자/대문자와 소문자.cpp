#include <string>
#include <vector>

using namespace std;

string solution(string my_string)
{
    for (int i = 0; i < my_string.length(); i++)
    {
        if (my_string[i] >= 'a' && my_string[i] <= 'z')
            my_string[i] -= 32;
        else if (my_string[i] >= 'A' && my_string[i] <= 'Z')
            my_string[i] += 32;
    }
    return my_string;
}
