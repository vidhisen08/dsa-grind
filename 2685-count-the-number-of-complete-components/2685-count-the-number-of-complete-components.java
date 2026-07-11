class Solution {
    int[] parent, size;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Map<Integer, Integer> nodeCount = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            nodeCount.put(root, nodeCount.getOrDefault(root, 0) + 1);
        }

        for (int[] edge : edges) {
            int root = find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        int result = 0;
        for (int root : nodeCount.keySet()) {
            int nodes = nodeCount.get(root);
            int edgesInComp = edgeCount.getOrDefault(root, 0);
            if (edgesInComp == nodes * (nodes - 1) / 2) {
                result++;
            }
        }

        return result;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        parent[rootY] = rootX;
        size[rootX] += size[rootY];
    }
}