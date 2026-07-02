class Solution {

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] best = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        int start = health - grid.get(0).get(0);

        if (start <= 0)
            return false;

        q.offer(new int[] { 0, 0, start });
        best[0][0] = start;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int h = curr[2];

            if (r == n - 1 && c == m - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nc >= 0 &&
                        nr < n && nc < m) {

                    int nh = h - grid.get(nr).get(nc);

                    if (nh > 0 && nh > best[nr][nc]) {
                        best[nr][nc] = nh;
                        q.offer(new int[] { nr, nc, nh });
                    }
                }
            }
        }

        return false;
    }
}