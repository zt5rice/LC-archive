class Solution274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        int tot = 0;
        for (int i = n; i >= 0; i--) {
            tot += count[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
    
    public int hIndex0(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length-1, res = 0;
        while (i>=0 && citations[i] > res) {
            res++; i--;
        }
        return res;
    }
}