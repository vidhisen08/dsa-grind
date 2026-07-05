class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1000000007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        score[0][0] = 0;
        ways[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == 0 && j == 0)
                    continue;

                int max = -1;
                int cnt = 0;

                int[][] dir = {
                    {i - 1, j},
                    {i, j - 1},
                    {i - 1, j - 1}
                };

                for (int[] d : dir) {
                    int x = d[0];
                    int y = d[1];

                    if (x < 0 || y < 0)
                        continue;

                    if (score[x][y] == -1)
                        continue;

                    if (score[x][y] > max) {
                        max = score[x][y];
                        cnt = ways[x][y];
                    } else if (score[x][y] == max) {
                        cnt = (cnt + ways[x][y]) % MOD;
                    }
                }

                if (max == -1)
                    continue;

                char ch = board.get(i).charAt(j);

                if (ch != 'S' && ch != 'E')
                    max += (ch - '0');

                score[i][j] = max;
                ways[i][j] = cnt;
            }
        }

        if (ways[n - 1][n - 1] == 0)
            return new int[]{0, 0};

        return new int[]{
            score[n - 1][n - 1],
            ways[n - 1][n - 1]
        };
    }
}