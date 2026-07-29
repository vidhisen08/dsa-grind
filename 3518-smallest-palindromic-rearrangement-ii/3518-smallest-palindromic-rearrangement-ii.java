import java.math.BigInteger;


class Solution {
    public String smallestPalindrome(String s, long k) {
        int n = s.length();
        int halfLen = n / 2;
        int[] freq = new int[26];
        for (int i = 0; i < halfLen; i++) freq[s.charAt(i) - 'a']++;

        BigInteger K = BigInteger.valueOf(k);
        BigInteger ways = countWays(freq, halfLen);

        if (K.compareTo(ways) > 0) return "";

        StringBuilder left = new StringBuilder();
        int remLen = halfLen;

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (freq[c] == 0) continue;

                // ways if we fix character c at this position
                BigInteger placeWays = ways.multiply(BigInteger.valueOf(freq[c]))
                                           .divide(BigInteger.valueOf(remLen));

                if (K.compareTo(placeWays) <= 0) {
                    left.append((char) ('a' + c));
                    freq[c]--;
                    remLen--;
                    ways = placeWays;
                    break;
                } else {
                    K = K.subtract(placeWays);
                }
            }
        }

        StringBuilder result = new StringBuilder(left);
        if (n % 2 == 1) result.append(s.charAt(n / 2));
        result.append(left.reverse());
        return result.toString();
    }

    // Multinomial coefficient: len! / (freq[0]! * freq[1]! * ... * freq[25]!)
    private BigInteger countWays(int[] freq, int len) {
        BigInteger numerator = factorial(len);
        BigInteger denom = BigInteger.ONE;
        for (int f : freq) {
            if (f > 1) denom = denom.multiply(factorial(f));
        }
        return numerator.divide(denom);
    }

    private BigInteger factorial(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) res = res.multiply(BigInteger.valueOf(i));
        return res;
    }
}