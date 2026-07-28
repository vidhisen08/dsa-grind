class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if (n == 1 || n == 2) {
            return s;
        }
        String firstHalf = s.substring(0, n / 2);
        char[] chars = firstHalf.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        String reversed = new String(chars);

        if (n % 2 == 0) {
            return sorted + reversed;
        } else {
            char middle = s.charAt(n / 2);
            return sorted + middle + reversed;
        }
    }
}