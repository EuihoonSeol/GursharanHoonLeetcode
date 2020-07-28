class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        if(nums.length==0||nums==null){
            return result;
        }        
        /* iterate from left to right and add multiplied value
        nums=>1,2,3,4
        left=6
        result=>1,1,2,6        
        */
        int left=1;
        int right=1;
        result[0]=1;
        
        for(int i=0;i<nums.length-1;i++){
            left=left*nums[i];
            result[i+1]=left;
        }        
        /*
        iterate from right to left and add multiplied value
        nums=>1,2,3,4
        right=24;
        result=>_,12,8,6
        */
        for(int i=nums.length-1;i>=1;i--){
            right=right*nums[i];
            result[i-1]=result[i-1]*right;            
        }        
        return result;        
    }
}
