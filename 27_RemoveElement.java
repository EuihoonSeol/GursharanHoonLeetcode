class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int number:nums){
            if(number!=val){
                nums[count]=number;
                count++;
            }
        }
        return count;
    }
}
