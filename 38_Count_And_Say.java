class Solution {
    /*
    1-> 1
    2-> 21
    3->1211
    
    */
    public String countAndSay(int n) {
        if(n<1){
            return null;
        }
        if(n==1){
            return Integer.toString(n);
        }
        StringBuilder sb=new StringBuilder();
        String s=countAndSay(n-1)+"*";
        int count=1;
       
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }
            else{
                sb.append(count);
                count=1;
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
