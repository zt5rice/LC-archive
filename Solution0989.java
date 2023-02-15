class Solution0989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int rem = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            rem += num[i] + k%10;
            k /= 10;
            res.add(rem%10);
            rem /= 10;
        }
        while (rem > 0 || k > 0) {
            rem += k%10;
            k /= 10;
            res.add(rem%10);
            rem /= 10;            
        }
        Collections.reverse(res);
        return res;
    }
}
