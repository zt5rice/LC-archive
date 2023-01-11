class Solution0435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        int overCount = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                overCount++;
                end = intervals[i][1];
            }
        }
        return intervals.length - overCount;
    }
}
// https://leetcode.cn/problems/non-overlapping-intervals/solution/wu-zhong-die-qu-jian-by-leetcode-solutio-cpsb/