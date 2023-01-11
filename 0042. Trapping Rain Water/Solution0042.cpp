class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0, right = height.size()-1, lMax = height[left], rMax = height[right];
        int water = 0;
        while (left < right) {
            lMax = max(lMax, height[left]);
            rMax = max(rMax, height[right]);
            if (height[left] < height[right]) {
                water += lMax - height[left];
                left++;
            } else {
                water += rMax - height[right];
                right--;
            }
        }
        return water;        
    }
};