class Solution1048 { // 08 - 13
    public int longestStrChain(String[] words) { // tc: nlogn+n*m^2, sc: n
        int longest = 0;
        Map<String, Integer> dist = new HashMap<>();
        Arrays.sort(words, (w1, w2) -> (w1.length() != w2.length()) ? (w1.length() - w2.length()) : (w1.compareTo(w2))); // t-nlogn
        for (String word : words) { // t-n
            int curLen = 0;
            for (int i = 0; i < word.length(); i++) {// t-m^2
                String tmpStr = word.substring(0, i) + word.substring(i+1);
                curLen = Math.max(curLen, dist.getOrDefault(tmpStr, 0));
            }
            dist.put(word, curLen + 1);
            longest = Math.max(longest, curLen + 1);
        }
        return longest;
    }
}

// https://leetcode.com/problems/longest-string-chain/discuss/294890/JavaC%2B%2BPython-DP-Solution