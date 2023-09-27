#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

int is_expired(string today, string p, int Validity) {
    int year = stoi(p.substr(0, 4));
    int month = stoi(p.substr(5, 2));
    int day = stoi(p.substr(8, 2));

    int year2 = stoi(today.substr(0, 4));
    int month2 = stoi(today.substr(5, 2));
    int day2 = stoi(today.substr(8, 2));

    int pToDays = (year * 12 * 28) + (month * 28) + day - 1 + Validity * 28;
    int tToDays = (year2 * 12 * 28) + (month2 * 28) + day2;
    
    return pToDays < tToDays ? 1 : 0;
}

vector<int> solution(string today, vector<string> terms, vector<string> p) {
    vector<int> answer;
    map<char, int> m;
    char alpha;
    int month;
    for (int i = 0; i < terms.size(); i++) {
        stringstream ss;
        ss.str(terms[i]);
        while (ss >> alpha >> month) m[alpha] = month;
    }
    for (int i = 0; i < p.size(); i++) 
        if (is_expired(today, p[i], m[p[i][11]]))
            answer.push_back(i + 1);

    return answer;
}