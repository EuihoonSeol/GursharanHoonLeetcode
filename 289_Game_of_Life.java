class Solution {
/*        
-1,-1   -1,0   -1,1
        
0,-1    0,0    0,1
            
1,-1     1,0    1,1        
*/    
    public void gameOfLife(int[][] board) {
        int rowLength=board.length;
        int colLength=board[0].length;
        /*
        live cell -> 1, dead-cell ->0
        intially dead- now live->-2, initally live-now dead->-1
        */
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                int livesCount=generateLive(board,rowLength,colLength,i,j);
                if(board[i][j]==1){
                    if(livesCount<2||livesCount>3){
                        board[i][j]=-1;
                    }
                }
                else{
                    if(livesCount==3){
                        board[i][j]=-2;
                    }
                }
            }
        }
            
            for(int i=0;i<rowLength;i++){
                for(int j=0;j<colLength;j++){
                    if(board[i][j]==-2){
                        board[i][j]=1;
                    }
                    else if(board[i][j]==-1){
                        board[i][j]=0;
                    }
                    
                }
            }
        }
    
public int generateLive(int[][]board,int rowLength,int colLength,int r,int c){
    int count=0;
    //top left element
    if(r-1>=0 && c-1>=0 &&(board[r-1][c-1]==1||board[r-1][c-1]==-1)){
        ++count;
    }
    //top element
    if(r-1>=0&&(board[r-1][c]==1||board[r-1][c]==-1)){
        ++count;
    }
    //top right element
    if(r-1>=0 &&c+1<colLength&&(board[r-1][c+1]==1||board[r-1][c+1]==-1)){
        ++count;
    }
    //left element
    if(c-1>=0&&(board[r][c-1]==1||board[r][c-1]==-1)){
        ++count;
    }
    //right element
    if(c+1<colLength&&(board[r][c+1]==1||board[r][c+1]==-1)){
        ++count;
    }
    //bottom left element
    if(r+1<rowLength&&c-1>=0 &&(board[r+1][c-1]==1||board[r+1][c-1]==-1)){
        ++count;
    }
    //bottom element
    if(r+1<rowLength&&(board[r+1][c]==1||board[r+1][c]==-1)){
        ++count;
    }
    //bottom right element
    if(r+1<rowLength&&c+1<colLength&&(board[r+1][c+1]==1||board[r+1][c+1]==-1)){
        ++count;
    }
    return count;
}
}    
    
    
