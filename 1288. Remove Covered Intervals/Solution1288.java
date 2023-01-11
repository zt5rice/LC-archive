class Solution1288 { // 03
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, 
                    (i1, i2) -> (i1[0] != i2[0]) ? (i1[0] - i2[0]) : (i2[1] - i1[1])
                   );
        int right = intervals[0][1];
        int count = 1;
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (intervals[i][1] > right) {
                count++;
                right = intervals[i][1];
            } 
        }
        return count;
    }
}

// https://leetcode.cn/problems/remove-covered-intervals/solution/by-stormsunshine-dgkn/