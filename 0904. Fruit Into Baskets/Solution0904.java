class Solution0904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int left = 0, n = fruits.length, digitCount = 0;
        int res = 0;
        for (int right = 0; right < n; right++) {
            if (!numMap.containsKey(fruits[right])) {
                digitCount++;
                numMap.put(fruits[right], 1);
            } else {
                numMap.put(fruits[right], numMap.get(fruits[right]) + 1);
            }
            while (digitCount > 2) {
                if (numMap.get(fruits[left]) == 1) {
                    digitCount--;
                    numMap.remove(fruits[left]);
                } else {
                    numMap.put(fruits[left], numMap.get(fruits[left]) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
// https://leetcode.cn/problems/fruit-into-baskets/solution/shen-du-jie-xi-zhe-dao-ti-he-by-linzeyin-6crr/