#include<vector>

using namespace std;

class Solution0645 {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            while (nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                swap(nums[i], nums[nums[i]-1]);
            }
        }
        int dup = -1, los = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) {
                dup = nums[i];
                los = i == 0 ? 1 : (nums[i-1]+1);
            }
        }
        return {dup, los};
    }
    
    void swap(int &a, int &b) {
        int temp = a;
        a = b;
        b = temp;
    }
};