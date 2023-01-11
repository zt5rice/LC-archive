class Solution0528 { // 50 - 54x
    int[] w;
    public Solution(int[] w) {
        this.w = w;
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i-1];
        }
    }
    
    public int pickIndex() {
        int rand = (int) (Math.random() * (w[w.length-1]));
        // find the first in w that > rand
        int left = 0, right = w.length - 1, mid = 0;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (w[mid] > rand) {
                 right = mid;
            } else {
               left = mid;
            }
        }
        if (w[left] > rand) {
            return left;
        }
        return right;
    }
}