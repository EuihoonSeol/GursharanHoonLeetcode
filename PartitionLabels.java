class Solution {
    public List<Integer> partitionLabels(String S) {
     ArrayList<Integer> result=new ArrayList<>();
        if(S==null||S.length()==0){
            return result;
        }
        /*
        S = "ababcbacadefegdehijhklij"
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11]
        [8, 5, 7, 14,15,11,13,19,22,23,20,21]
        [a, b, c, d, e, f, g, h, i, j, k, l]
        myarray value=>position=>character 
                    
        */
        int[] myarray=new int[26];
        for(int i=0;i<S.length();i++){
            myarray[S.charAt(i)-'a']=i;
        }
        
        int prev=0;
        int currentMax=0;
        for(int i=0;i<S.length();i++){
         if(myarray[S.charAt(i)-'a']>currentMax){
             currentMax=myarray[S.charAt(i)-'a'];
         }
            if(i==currentMax){
                result.add(i-prev+1);
                prev=i+1;
            }
            
            
        }
        
        return result;
        
        
    }
}
