#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool comp(string a, string b) { return a + b > b + a; }

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> arr;
    bool flag = true;
    for (int i = 0; i < numbers.size(); i++) {
        arr.push_back(to_string(numbers[i]));
        if (numbers[i] != 0)
                flag = false;
    }
    if (flag)
        return "0";
        
    sort(arr.begin(), arr.end(), comp);
    for (int i = 0; i < arr.size(); i++) answer += arr[i];
    return answer;
}