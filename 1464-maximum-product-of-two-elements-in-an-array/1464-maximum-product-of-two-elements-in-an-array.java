class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Math.max(nums[0],nums[1]);
        int sm =  Math.min(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            if (nums[i] > max) {
                sm = max;
                max = nums[i];
            } else if (nums[i] > sm) {
                sm = nums[i];
            }
        }
        return (max - 1) * (sm - 1);
    }
}