class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()){
            return -1;
        }
        /*
        haystack="hello" -> 5
        needle="ll" -> 2
        i=0,j=0 || i=0,j=1
        i=1,j=0 || i=1,j=1 
        i=e,j=l || i=e,j=l
        i=2,j=0 || i=2,j=1
        i=l,j=l || i=l,j=l
                
        */
        
          if (needle == null) {
            return -1;
        }
        
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int j=0;
            for(;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
                if(j==needle.length()){
                    return i;
                
            }
        }
        
        return -1;
    }
}
