class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // Find maximum element
        int max = nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
       

        // Find next power of 2 greater than max
        int size = 1;
        while (size <= max) {
            size*=2;
        }

        boolean[] pair = new boolean[size];
        boolean[] ans = new boolean[size];

        // Store all possible XORs of two elements
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        // XOR every pair XOR with every element
        for (int x = 0; x < size; x++) {
            if (!pair[x]){
                continue;
            } 
            for (int num : nums) {
                ans[x ^ num] = true;
            }
        }

        // Count unique XOR values
        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}