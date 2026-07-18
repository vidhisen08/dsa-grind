class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }

            if(nums[i]<min){
                min = nums[i];
            }
        }
        while(max!=0){
            int temp = min % max;
            min = max;
            max = temp;
        }
        return min;
    }
}