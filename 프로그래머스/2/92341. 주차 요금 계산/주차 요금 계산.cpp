#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <cmath>
using namespace std;


int get_stayed_time(map<string, string> cars, string carNum, string out) {
    string in = cars[carNum];
    int in_time = stoi(in.substr(0, 2)) * 60 + stoi(in.substr(3, 2));
    int out_time = stoi(out.substr(0, 2)) * 60 + stoi(out.substr(3, 2));
    return out_time - in_time;
}

int get_price(int stayed_time, vector<int> fees) {
    if (stayed_time <= fees[0]) return fees[1];
    double c = double(stayed_time - fees[0]) / fees[2];
    return fees[1] + ceil(c) * fees[3];
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    map<string, int> stayed_time;
    map<string, string> cars;
    string num, time, act;
    for (int i = 0; i < records.size(); i++) {
        stringstream ss(records[i]);
        ss >> time >> num >> act;
        if (act == "IN") {
            cars[num] = time;
        } else if (act == "OUT") {
            stayed_time[num] += get_stayed_time(cars, num, time);
            cars.erase(num);
        }
    }
    for (auto it = cars.begin(); it != cars.end(); it++)
        stayed_time[it->first] += get_stayed_time(cars, it->first, "23:59");

    for (auto it = stayed_time.begin(); it != stayed_time.end(); it++)
        answer.push_back(get_price(it->second, fees));

    return answer;
}