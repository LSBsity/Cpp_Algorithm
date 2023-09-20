#include <iostream>
#include <string>

using namespace std;

int main()
{
    string a;

    string alpha = "abcdefghijklmnopqrstuvwxyz";

    cin >> a;
    for (int i = 0; i < alpha.length(); i++)
    {
        cout << int(a.find(alpha[i])) << " ";
    }
    
    




    return 0;
}