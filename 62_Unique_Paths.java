class Solution {
    public int uniquePaths(int m, int n) {
 
        if(m==0 || n==0){
            return 0;
        }
        /*
        1  1  1
        1  2  3
        1  3  6
        
        row=2,col=1
        */
        
        int[][] result=new int[m][n];
        
        for(int col=0;col<result[0].length;col++){
            result[0][col]=1;
        }
        
        for(int row=0;row<result.length;row++){
            result[row][0]=1;
        }
        
        for(int row=1;row<m;row++){
            for(int col=1;col<n;col++){
                result[row][col]=result[row-1][col]+result[row][col-1];
            }
        }
        
        return result[m-1][n-1];

    }
}
