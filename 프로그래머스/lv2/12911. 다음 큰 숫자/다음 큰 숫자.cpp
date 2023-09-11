#include <string>
#include <vector>
#include <bitset>
using namespace std;

int solution(int n)
{
    int count = 0;
    string a = bitset<19>(n).to_string();

    for (int i = 0; i < a.length(); i++)
        if (a[i] == '1') count++;

    int z = 1;
    
    while (1)
    {
        int count2 = 0;
        string b = bitset<19>(n + z).to_string();
        for (int i = 0; i < a.length(); i++)
            if (b[i] == '1') count2++;

        if (count == count2) break;
        z++;
    }
    return n + z;
}