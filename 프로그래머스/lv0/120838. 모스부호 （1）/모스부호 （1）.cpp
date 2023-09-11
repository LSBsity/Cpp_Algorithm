#include <string>
#include <vector>
#include <map>
#include <sstream>
using namespace std;

map<string, char> morse;
string arr[26] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                  ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                  "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

string solution(string letter)
{
    string answer = "";
    string str = "";
    stringstream ss(letter);
    char c = 'a';

    for (int i = 0; i < 26; i++)
        morse[arr[i]] = c+i;

    
    while (ss>> str)
    {
        answer+=morse[str];
    }
    

    return answer;
}