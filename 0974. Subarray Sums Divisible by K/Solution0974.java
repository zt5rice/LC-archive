public class Solution0974 {
    public int subarraysDivByK(int[] nums, int k) {
		//stores the remainders
        int m[]=new int[k];
        int sum=0;
        int count=0;
        m[0]=1;
        for(int x: nums){
            sum+=x;
            int rem=sum%k;
            if(rem<0) rem+=k;
            count+=m[rem];
            m[rem]++;
        }
        return count;
    }
}