import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        int lo = 0, hi = 0;   // <-- changed from 1 to 0
        for (int[] e : edges) {
            hi = Math.max(hi, e[2]);
        }

        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (feasible(n, edges, online, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean feasible(int n, int[][] edges,
                             boolean[] online,
                             long k,
                             int minEdge) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph using only valid edges
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int cost = e[2];

            if (cost < minEdge) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;
            if (v != 0 && v != n - 1 && !online[v]) continue;

            graph.get(u).add(new int[]{v, cost});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();

            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            if (node == n - 1) break;

            for (int[] next : graph.get(node)) {
                int v = next[0];
                int w = next[1];

                long nd = d + w;

                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{v, nd});
                }
            }
        }

        return dist[n - 1] <= k;
    }
}