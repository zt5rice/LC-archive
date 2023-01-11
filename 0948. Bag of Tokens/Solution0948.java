class Solution0948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        int point = 0, res = 0;
        Arrays.sort(tokens);
        int left = 0, n = tokens.length, right = n - 1;
   
        while (left <= right) {
            if (power >= tokens[left]) {
                point++;
                power -= tokens[left++];
                res = Math.max(point, res);
            } else if (left <= right && point > 0) {
                point--;
                power += tokens[right--];
            } else {
                break;
            }
        }
        
        return res;
    }
}
// 作者：LeetCode
// 链接：https://leetcode.com/problems/bag-of-tokens/discuss/197696/C%2B%2BJavaPython-Greedy-%2B-Two-Pointers
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。