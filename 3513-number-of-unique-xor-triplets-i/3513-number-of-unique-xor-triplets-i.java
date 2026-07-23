class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==1 || n==2){
            return n;
        }
        int ans = 1; // 2 to the power 0
        while(ans<=n){
            ans*=2; // power increase till it cross the number 
        }
        return ans;
    }
}