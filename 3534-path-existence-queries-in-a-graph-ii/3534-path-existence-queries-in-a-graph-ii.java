import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idxArr = new Integer[n];
        for (int i = 0; i < n; i++) idxArr[i] = i;
        Arrays.sort(idxArr, (a, b) -> nums[a] - nums[b]);

        int[] sortedVal = new int[n];
        int[] pos = new int[n]; // original index -> position in sorted order
        for (int i = 0; i < n; i++) {
            sortedVal[i] = nums[idxArr[i]];
            pos[idxArr[i]] = i;
        }

        // r[i] = farthest index reachable in ONE hop from i
        int[] r = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i) j = i;
            while (j + 1 < n && sortedVal[j + 1] - sortedVal[i] <= maxDiff) j++;
            r[i] = j;
        }

        int[] comp = new int[n];
        int curComp = 0;
        for (int i = 1; i < n; i++) {
            if (r[i - 1] < i) curComp++;
            comp[i] = curComp;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++;
        int[][] jump = new int[LOG][n];
        jump[0] = r;
        for (int k = 1; k < LOG; k++)
            for (int i = 0; i < n; i++)
                jump[k][i] = jump[k - 1][jump[k - 1][i]];

        int m = queries.length;
        int[] ans = new int[m];
        for (int qi = 0; qi < m; qi++) {
            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];
            if (u == v) { ans[qi] = 0; continue; }
            int a = Math.min(u, v), b = Math.max(u, v);
            if (comp[a] != comp[b]) { ans[qi] = -1; continue; }

            int cur = a, steps = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < b) {
                    cur = jump[k][cur];
                    steps += (1 << k);
                }
            }
            steps += 1; 
            ans[qi] = steps;
        }
        return ans;
    }
}