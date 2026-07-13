class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        String str = "123456789";

        int min = String.valueOf(low).length();
        int max = String.valueOf(high).length();

        for (int len = min; len <= max; len++) {

            for (int st = 0; st <= 9 - len; st++) {

                String temp = str.substring(st, st + len);
                int num = Integer.parseInt(temp);

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}