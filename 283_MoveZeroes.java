public class MoveZeroes {
    public static void moveZeroesMethod(int[] nums){
        if(nums==null||nums.length==0){
            return;
        }

        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }
        for(int i=index;i<nums.length;i++){
            nums[index++]=0;
        }

    }
    public static void main(String[] args){
        int[] arr={0,1,0,3,12};
        moveZeroesMethod(arr);
        for(int num:arr){
            System.out.println(num);

        }
    }
}
