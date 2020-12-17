class Solution {
    public int findMaxLength(int[] nums) {
     // Enter the count and the arrays number
        HashMap<Integer,Integer> mymap=new HashMap();
        mymap.put(0,-1);
        int count=0;
        int maxlength=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count=count-1;
            }
            else{
                count+=1;
            }
            
            if(mymap.containsKey(count)){
                maxlength=Math.max(maxlength,i-mymap.get(count));
            }
            else{
                mymap.put(count,i);
            }
        }
        return maxlength;
    }
}
