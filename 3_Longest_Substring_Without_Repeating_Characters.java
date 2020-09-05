/*
We will be using sliding window technique with the help of the start pointer and end pointer. 
If see non duplicate character, we will add it to the hashset and then increase the end pointer. Now we need to calculate the size of the hashset as well.
when we got the duplicate or repeating character, we will take the first character out at the starting pointer because that is how window works and you 
will move the start pointer ahead.

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
     if(s.length()==0){
         return 0;
     }   
        int maxlength=0;
        HashSet<Character> myset=new HashSet();
        int startpointer=0;
        int endpointer=0;
        while(endpointer<s.length()){
            if(!myset.contains(s.charAt(endpointer))){
                myset.add(s.charAt(endpointer));
                endpointer++;
                maxlength=Math.max(maxlength,endpointer-startpointer);
            }
            else{
                myset.remove(s.charAt(startpointer));
                startpointer++;
            }
        }
        
        return maxlength;
    }
}
