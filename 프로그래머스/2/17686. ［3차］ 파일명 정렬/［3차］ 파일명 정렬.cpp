#include <string>
#include <vector>
#include <algorithm>
#include <regex>

using namespace std;

bool comp(string a, string b) {
    regex pat(R"(([^0-9]+)(0*([0-9]{1,5}))(.*))");
    smatch mat;

    regex_match(a, mat, pat);
    string head1 = mat[1];
    string number1 = mat[2];

    regex_match(b, mat, pat);
    string head2 = mat[1];
    string number2 = mat[2];

    transform(head1.begin(), head1.end(), head1.begin(), ::tolower);
    transform(head2.begin(), head2.end(), head2.begin(), ::tolower);

    int n1 = stoi(number1);
    int n2 = stoi(number2);

    return head1 == head2 ? n1 < n2 : head1 < head2;
}

vector<string> solution(vector<string> f) {
    stable_sort(f.begin(), f.end(), comp);
    return f;
}
