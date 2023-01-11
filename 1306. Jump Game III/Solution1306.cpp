#include<iostream>
#include<string>
#include<vector>

using namespace std;

class Solution1306 {
public:
    bool canReach(vector<int>& arr, int start) {
        if (start < 0 || start >= arr.size() || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        arr[start] = -arr[start];
        return canReach(arr, start-arr[start]) || canReach(arr, start+arr[start]);
    }
};