class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int count=0;
        for(int number:nums){
            if(number==val){               
                continue;
            }
            else{
                 nums[count]=number;
                count++;
            }
        }        
        return count;
    }
}
