#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    for (int i = 0; i < str.size(); i++)
    {
        if (isupper(str[i])) str[i] = tolower(str[i]);
        else str[i] = toupper(str[i]);
    }
    
    cout << str;
    
    return 0;
}