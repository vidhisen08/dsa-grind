class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // store all pair xor
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                set.add(nums[i] ^ nums[j]);
            }
        }

        // find xor triplets
        HashSet<Integer> pairXor = new HashSet<>();
        for(int pair: set){   // using foreach cuz sets don't store elements by index
            for(int x: nums){
                pairXor.add(pair ^ x);
            }
        }
        return pairXor.size();
    }
}