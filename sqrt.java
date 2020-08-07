class Solution {
    public int mySqrt(int x) {
        /*
        Using binary search to find the middle of the integer
        */
        if(x==0){
            return 0;
        }
        if(x<=1){
            return x;
        }
        long start=1;
        long end=x;
        while(start+1<end){
            long mid=(start+(end-start)/2);
            if(mid*mid==x){
                return (int)mid;
            }
           if(mid*mid<x){
               start=mid;
           }
            else{
                end=mid;
            }
        }
        
        if(end*end==x){
            return (int)(end);
        }
        else{
            return (int)(start);
        }
        
        
    }
}
