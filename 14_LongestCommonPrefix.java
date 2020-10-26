/*

Start from the first word and then check the second and subsequent words in the array. 
If the subsequent words don't match then keep on reducing the length of the first fixed word.


*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String prefix=strs[0];
        
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        
        return prefix;
    }
}
