class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        // stores distance of each cell from nearest thief
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        // put all thieves in queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(grid.get(i).get(j) == 1){
                    dist[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        // Multi-source BFS
        while(!q.isEmpty()){

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int k = 0; k < 4; k++){

                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nc >= 0 &&
                   nr < n && nc < n &&
                   dist[nr][nc] == -1){

                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        int low = 0;
        int high = 2 * n;
        int ans = 0;

        // Binary Search
        while(low <= high){

            int mid = low + (high - low)/2;

            if(isPossible(dist, mid)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[][] dist, int safe){

        int n = dist.length;

        if(dist[0][0] < safe)
            return false;

        boolean[][] vis = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty()){

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            if(r == n-1 && c == n-1)
                return true;

            for(int k = 0; k < 4; k++){

                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nc >= 0 &&
                   nr < n && nc < n &&
                   !vis[nr][nc] &&
                   dist[nr][nc] >= safe){

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        return false;
    }
}