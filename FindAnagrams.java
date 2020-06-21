class Solution {
    /*
    s=9,p=3
    s=baebabacd   p=abc
   first 5 elements sArray[]=00001
   first 5 elements pArray[]=11100
    i=1 till 6
    
    */    
    public List<Integer> findAnagrams(String s, String p) {
                ArrayList<Integer> result=new ArrayList<>();

        if(s==null ||p==null ||s.length()==0){
            return result;
        }
        if(s.length()<p.length()){
            return result;
        }
        int [] sArray=new int[26];
        int [] pArray=new int[26];
        
        for(int i=0;i<p.length();i++){
            pArray[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            sArray[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length()-p.length()+1;i++){
            // if matched then add that position to the list
            if(isMatch(sArray,pArray)){
                result.add(i);
            }
            // otherwise make the previous element as 0 and move the window to the                      next position 
            if(i!=s.length()-p.length()){
            sArray[s.charAt(i)-'a']--;
            sArray[s.charAt(i+p.length())-'a']++;
            }
            
            
        }
        
        
        
        
        
        
        return result;
    }
    
    
    public boolean isMatch(int[] firstArray,int[] secondArray){
        for(int i=0;i<firstArray.length;i++){
            if(firstArray[i]!=secondArray[i]){
                return false;
            }
        }
        return true;
    }
}
