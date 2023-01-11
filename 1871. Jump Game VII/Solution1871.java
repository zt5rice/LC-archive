class Solution1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int cnt = 1;
        boolean[] dp = new boolean[s.length()];
        dp[0]=true;//!!!!!!!
        for (int i = minJump; i < s.length(); i++) {
            if (s.charAt(i) == '0' && cnt > 0) {
                dp[i] = true;
            }
            // update left and right
            if (i >= maxJump && dp[i-maxJump]) {
                cnt--;
            }
            // update right
            if (i + 1>= minJump && dp[i-minJump+1]) {
                cnt++;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[s.length() - 1];
    }
}

// 作者：baizimiao
// 链接：https://leetcode.cn/problems/jump-game-vii/solution/hua-chuang-si-xiang-dp-bu-xu-yao-qian-zh-j865/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。