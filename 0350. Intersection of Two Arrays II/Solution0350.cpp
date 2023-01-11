#include<stdio.h>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        int n1 = nums1.size(), i1 = 0;        
        int n2 = nums2.size(), i2 = 0;
        sort(nums1.begin(), nums1.end());        
        sort(nums2.begin(), nums2.end());
        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                res.push_back(nums1[i1]);
                i1++;
                i2++;
            }
        }
        return res;
    }
};