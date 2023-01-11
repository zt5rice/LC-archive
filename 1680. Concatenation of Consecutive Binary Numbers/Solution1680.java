public class Solution1680 {
    public int concatenatedBinary(int n) {
        int digits = 0, MOD = 1000000007;
        long result = 0;
        for(int i = 1; i <= n; i++){
			/* if "i" is a power of 2, then we have one additional digit in
			   its the binary equivalent compared to that of i-1 */
            if((i & (i - 1)) == 0) digits++; 
            result = ((result << digits) + i) % MOD;
        }
        
        return (int) result;
    }
    public int concatenatedBinary1(int n) {
        final int MOD = 1000000007;
        int length = 0; // bit length of addends
        long result = 0; // long accumulator
        for (int i = 1; i <= n; i++) {
            // when meets power of 2, increase the bit length
            if (Math.pow(2, (int) (Math.log(i) / Math.log(2))) == i) {
                length++;
            }
            result = ((result * (int) Math.pow(2, length)) + i) % MOD;
        }
        return (int) result;
    }
    public int concatenatedBinary0(int n) {
        int mod = (int) 1e9+7;
        long res = 0L;
        for (int i = 1; i <= n; i++) {
            int offset = 0;
            int tmp = i;
            while (tmp != 0) {
                offset++;
                tmp >>= 1;
                res <<= 1;
            }
            res %= mod; 
            while (offset != 0) {
                if ((i & (1<<(offset-1))) != 0) {
                    res += (1<<(offset-1));
                }
                offset--;
            }
            res %= mod;
        }
        return (int) (res % mod);
    }    
}
