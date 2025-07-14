package turing;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        for(int i =0;i <nums.length;i++){
            int unique=0;
            for(int j = 0 ;j<nums.length; j++){
                if(nums[i] == nums[j] && i != j){
                    unique++;
                }
            }
            if(unique ==0){
                return nums[i];
            }
        }
        return -1;
    }
}
