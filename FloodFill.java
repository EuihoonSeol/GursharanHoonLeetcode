class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       
        int oldColor=image[sr][sc];
        if(oldColor==newColor){
            return image;
        }
         floodUtil(image,oldColor,newColor,sr,sc);
       
        return image;
    // O(m*n)
        
    }
    public void floodUtil(int[][] image,int oldColor,int newColor,int sr,int sc){
        
        if(image[sr][sc]!=oldColor){
            return;
        }else{            
            image[sr][sc]=newColor;
              
        }
        if(sr-1>=0 ){
            floodUtil( image,oldColor,newColor,sr-1,sc);
            }
        if(sc-1>=0 ){
                        floodUtil(image,oldColor,newColor,sr,sc-1);
        }
                if(sr+1<image.length){
            floodUtil(image,oldColor,newColor,sr+1,sc);
            }
        if( sc+1<image[0].length){
                        floodUtil( image,oldColor,newColor,sr,sc+1);

        }
    }
   
    
    
}
