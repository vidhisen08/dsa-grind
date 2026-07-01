class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int rev = 0;
        while(x>0){
            int lastdigit = x % 10;
            rev = rev*10 + lastdigit;
            x=x/10;
        }
        return original == rev;
    }
}