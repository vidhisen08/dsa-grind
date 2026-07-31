class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Sort frequencies in descending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        int idx = 25; // start from highest frequency
        
        for (int i = 0; i < 26 && freq[idx] > 0; i++) {
            int pushCost = (i / 8) + 1; // 8 letters per key-press level
            totalPushes += freq[idx] * pushCost;
            idx--;
        }
        
        return totalPushes;
    }
}