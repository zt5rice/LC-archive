import java.util.*;

public class Solution1044 {
    long[] h, p;
    public String longestDupSubstring(String s) {
        int P = 1313131, n = s.length();
        h = new long[n+1]; p = new long[n+1];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
        String ans = "";
        int l = 0, r = n;
        while (l < r) {
            // int mid = l + (r - l) / 2;
            int mid = l + r + 1 >> 1;
            String t = check(s, mid);
            if (t.length() != 0) l = mid;
            else r = mid - 1;
            ans = t.length() > ans.length() ? t : ans;
        }
        return ans;
    }
    String check(String s, int len) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            long cur = h[j] - h[i - 1] * p[j - i + 1];
            if (set.contains(cur)) return s.substring(i - 1, j);
            set.add(cur);
        }
        return "";
    }
    
    public static void main(String[] args) {
        Solution1044 sol = new Solution1044();
        String s = "banana";
        String res = sol.longestDupSubstring(s);
        System.out.println(res);
    }
}

// 作者：AC_OIer
// 链接：https://leetcode.cn/problems/longest-duplicate-substring/solution/gong-shui-san-xie-zi-fu-chuan-ha-xi-ying-hae9/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。