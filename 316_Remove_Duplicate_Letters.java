class Solution {
    /*
    when the letter c we try to append is lexicographically smaller than the 
    letter in the end of the result string e we try to find whether e appears
    after c , use count[] to check if yes we delete the e else just append c        
    */
    public String removeDuplicateLetters(String s) {
     StringBuilder sb=new StringBuilder();
        int[] count=new int[26];
        boolean[] used=new boolean[26];
        char[] mycharArray=s.toCharArray();
        for(char ch:mycharArray){
            count[ch-'a']++;
        }        
        for(char ch:mycharArray){
            count[ch-'a']--;
            if(used[ch-'a']){
                continue;
            }
            while(sb.length()>0 && ch<sb.charAt(sb.length()-1)&&count[sb.charAt(sb.length()-1)-'a']>0){
                used[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(ch);
            used[ch-'a']=true;
        } 
        return sb.toString(); 
        
        }
}
