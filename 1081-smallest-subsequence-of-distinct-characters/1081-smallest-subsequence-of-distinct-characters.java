class Solution {
    public String smallestSubsequence(String s) {

        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();
        boolean[] vis = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (vis[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty()
                    && ch < st.peek()
                    && last[st.peek() - 'a'] > i) {

                vis[st.pop() - 'a'] = false;
            }

            st.push(ch);
            vis[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : st) {
            ans.append(c);
        }

        return ans.toString();
    }
}
