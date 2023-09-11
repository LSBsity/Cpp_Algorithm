#include <string>
#include <algorithm>
#include <vector>

using namespace std;

string solution(string my_string)
{
    char vowel[5] = {'a', 'e', 'i', 'o', 'u'};
    
    for (int i = 0; i < 5; i++)
        my_string.erase(remove(my_string.begin(), my_string.end(), vowel[i]), my_string.end());
    
    return my_string;
}