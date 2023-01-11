class Solution2444 {
    public long countSubarrays(int[] A, int minK, int maxK) {
        long res = 0, jbad = -1, jmin = -1, jmax = -1, n = A.length;
        for (int i = 0; i < n; ++i) {
            //     jbad <(...>          i]
            //             jmin,jmax    
            
            if (A[i] < minK || A[i] > maxK) jbad = i;
            if (A[i] == minK) jmin = i;
            if (A[i] == maxK) jmax = i;
            res += Math.max(0L, Math.min(jmin, jmax) - jbad);
            System.out.println(i+":"+jbad + "," + jmin + "," + jmax + "::" + (Math.min(jmin, jmax) - jbad));
        }
        return res;        
    }
}