class Solution0350 { // tc: o(nlogn + mlogm), sc: o(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                res.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
            // System.out.println(i1 + ',' + i2);
        }
        int[] rst = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            rst[i] = res.get(i);
        }
        return rst;
    }
}

class Solution0 { // tc: o(m + n), sc: o(min(m, n)), len(nums1)=m, len(nums2)=n;
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        // use map to store info nums1, shorter
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums1) {
            int ct = freqMap.getOrDefault(num, 0);
            freqMap.put(num, ct + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (freqMap.containsKey(num)) {
                res.add(num);
                int ct = freqMap.get(num);
                if (ct == 1) {
                    freqMap.remove(num);
                } else {
                    freqMap.put(num, ct - 1);
                }
            }
        }
        int[] rst = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            rst[i] = res.get(i);
        }
        return rst;
    }
}