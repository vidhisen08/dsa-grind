class Solution {
    public int maxProduct(int n) {
        int m = 0;
        int sm = 0;
        while(n>0){
            int x = n%10;
            if(x>m){
                sm = m;
                m = x;
            }
            else if(x>sm){
                sm = x;
            }
            n = n/10;
        }
        return m*sm;
    }
}