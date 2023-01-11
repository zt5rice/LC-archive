#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        sort(properties.begin(), properties.end(), [](auto &a, auto &b){
            return a[0] > b[0] || (a[0] == b[0] && a[1] < b[1]);
        });
        int maxAtt = 0, count = 0;
        for (auto p : properties) {
            if (p[1] < maxAtt) {
                count++;
            } else {
                maxAtt = p[1];
            }
        }
        return count;
    }
};