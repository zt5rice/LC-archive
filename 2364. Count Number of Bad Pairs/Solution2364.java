public class Solution2364 {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> countMap = new HashMap<>();
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            long curCount = countMap.getOrDefault(nums[i] - i, 0L);
            res += curCount;
            countMap.put(nums[i] - i, curCount + 1L);
        }
        long len = (long) nums.length;
        return len * (len - 1) / 2 - res;
    }
}