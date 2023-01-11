public class Solution0342 {
    public boolean isPowerOfFour0(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
      }
    
      public boolean isPowerOfFour(int num ) {
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
      }    
}
