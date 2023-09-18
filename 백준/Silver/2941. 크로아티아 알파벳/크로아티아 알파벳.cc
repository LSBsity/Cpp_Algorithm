#include <iostream>
#include <vector>
#include <string>
using namespace std;


int main()
{
    vector<string> croatian = {"c=","c-","dz=","d-","lj","nj","s=","z="};

    string input;
    cin >> input;
    int idx;

    for (int i = 0; i < croatian.size(); i++)
    {
        while (1)
        {
            idx = input.find(croatian[i]);
            if (idx == string::npos)
                break;
            input.replace(idx, croatian[i].length(), "@");
        }
        
    }
    cout << input.length() << endl;
        
    return 0;
}