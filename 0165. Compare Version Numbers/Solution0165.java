public class Solution0165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");        
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        // System.out.println(v1.length + "," + v2.length);
        for (int i = 0; i < n; i++) {
            int n1 = v1.length <= i ? 0 : Integer.parseInt(v1[i]);            
            int n2 = v2.length <= i ? 0 :Integer.parseInt(v2[i]);
            if (n1 != n2) {
                return n1 > n2 ? 1 : -1;
            }
        }
        return 0;
    }
}    
