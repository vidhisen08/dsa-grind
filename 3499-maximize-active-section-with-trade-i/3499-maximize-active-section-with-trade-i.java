class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count1++;
            }
        }

        int ans = count1;

        s = "1" + s + "1";
        int l = s.length();

        for (int i = 1; i < l - 1;) {

            if (s.charAt(i) == '0') {
                i++;
                continue;
            }

            int j = i;

            while (j < l && s.charAt(j) == '1') {
                j++;
            }

            if (j<l && s.charAt(i - 1) == '0' && s.charAt(j) == '0') {

                int left = 0;
                int k = i - 1;

                while (k >= 0 && s.charAt(k) == '0') {
                    left++;
                    k--;
                }

                int right = 0;
                k = j;

                while (k < l && s.charAt(k) == '0') {
                    right++;
                    k++;
                }

                ans = Math.max(ans, count1 + left + right);
            }

            i = j;
        }

        return ans;
    }
}