class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result=new LinkedList<>();
        if(nums==null|| nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            while(i!=0 &&i<nums.length-1 &&nums[i]==nums[i-1]){                
                i++;
            }
            
            
            int j=i+1;
            int k=nums.length-1;
            
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList<Integer> mylist=new ArrayList<>();
                        mylist.add(nums[i]);
                        mylist.add(nums[j]);
                        mylist.add(nums[k]);
                        result.add(mylist);
                        int leftVal=nums[j];
                        while(j<nums.length && nums[j]==leftVal){
                            j++;
                            }
                        int rightVal=nums[k];
                        while(k>j && nums[k]==rightVal){
                            k--;
                            }
                }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                else{
                    j++;
                }
                
                
            }
            
            
        }
        return result;
        
        
        
    }
}
