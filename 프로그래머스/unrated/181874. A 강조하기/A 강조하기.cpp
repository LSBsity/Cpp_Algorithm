#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    for (int i = 0; i < myString.size(); i++)
    {
        if (myString[i] == 'a') myString[i] = 'A';
        else if (myString[i] >= 'B' && myString[i] <= 'Z') myString[i] += 32;
    }
    return myString;
}