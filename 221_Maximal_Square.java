class Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0;
        if(matrix==null ||matrix.length==0){
            return max;
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        int[][]result=new int[rows][columns];
        
        for(int i=0;i<rows;i++){
            result[i][0]=matrix[i][0]=='0'?0:1;
            max=Math.max(result[i][0],max);
        }
        
        for(int j=0;j<columns;j++){
            result[0][j]=matrix[0][j]=='0'?0:1;
            max=Math.max(result[0][j],max);
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<columns;j++){
                if(matrix[i][j]=='1'){
                    result[i][j]=Math.min(Math.min(result[i-1][j-1],result[i-1][j]),result[i][j-1])+1;
                    max=Math.max(result[i][j],max);
                }
            }
        }        
        return max*max;
    }
}
