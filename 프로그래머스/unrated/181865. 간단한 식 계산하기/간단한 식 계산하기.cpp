#include <string>
#include <vector>
#include <sstream>
using namespace std;

int solution(string binomial)
{
    stringstream ss;
    ss.str(binomial);
    vector<string> v;
    string temp;
    while(ss >> temp)
        v.push_back(temp);
    int b = stoi(v.back());
    v.pop_back();
    char op = v.back()[0];
    v.pop_back();
    int a = stoi(v.back());
    
    return op == '+' ? a + b : op == '-' ? a - b : a * b;
}