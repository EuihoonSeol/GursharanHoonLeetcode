class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < board.length; row++){
        Set<Character> setRow = new HashSet<>();
            for(int col=0;col<board[row].length;col++){
                if(board[row][col]=='.'){
                    continue;
                }                
                if(setRow.contains(board[row][col])){
                    return false;
                }                
                    setRow.add(board[row][col]);                
            }
    }    
            for(int row = 0; row < board.length; row++){
        Set<Character> setCol = new HashSet<>();
                    for(int col=0; col < board[row].length; col++){                 
                    if(board[col][row]=='.'){
                        continue;
                    }
                        if(setCol.contains(board[col][row])){
                            return false;
                        }                        
                            setCol.add(board[col][row]);                  
            }
        }
        
        // check if square is valid
        for(int row=0;row<board.length;row=row+3){
            for(int column=0;column<board[row].length;column=column+3){
                HashSet<Character> myset=new HashSet();
                for(int r=row;r<row+3;r++){
                    for(int c=column;c<column+3;c++){
                        if(board[r][c]=='.'){
                            continue;
                        }
                        if(myset.contains(board[r][c])){
                            return false;
                        }
                        myset.add(board[r][c]);
                    }
                }
            }
        }        
        return true;
    }
}
