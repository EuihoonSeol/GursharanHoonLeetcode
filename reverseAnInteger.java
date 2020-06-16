class Solution {
    public int reverse(int x) {
        /*
        Range of intergers => 2,147,483,647 and -214,483,648
        
    648
    649
    
        -123 => 
        remainder =x%10 => -1
        x=x/10 =>-1
        intial result=0;
                if(result>max interger/10 or result==max int/10 and remainder >7)
                if(result <min interger/10 or result=max int/10 and remaninder <-8)
        result=10*result+remainder 
        
        -3
        result=result*10+remainder=-3
        -30-2=>-32*10=-320
         while x > 0 
            remainder =x%10;
            quotient=x/10;
            x=x/10;
            result=
        
        */
        
         int result=0;
        int remainder=0;
        while(x!=0){
            remainder=x%10;
            x=x/10;
            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 &&remainder>7)){
                return 0;
            }
               if(result<Integer.MIN_VALUE/10 || (result==Integer.MIN_VALUE/10 && remainder<-8)){
                   return 0;
               }
            result=result*10+remainder;
            
        }
        
        return result;
    }
}
