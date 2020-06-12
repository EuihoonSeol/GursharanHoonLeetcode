public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=32;
        int result=0;
        while(count-->0){
            if((n&1)==1){
                result++;
            }
            n>>=1;
        }
        return result;
        
    }
}
