private static int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

public List<Integer> numIslands2(int m, int n, int[][] positions) {
   List<Integer> ans = new ArrayList();
   if (positions == null || positions.length == 0 || positions[0].length == 0) {
        return ans;
   }
   boolean[] visited = new boolean[n * m];
   UnionFind uf = new UnionFind(n * m);
   for (int[] pos : positions) {
        int x = pos[0], y = pos[1], id = x * n + y;
        visited[id] = true;
        uf.add(id);
        // check neighbors
        for (int[] dir : directions) {
            int xx = x + dir[0], yy = y + dir[1], newId = xx * n + yy;
            if (xx >= 0 && xx < m && yy >= 0 && yy < n && visited[newId] == true) {
                uf.union(id, newId);
            }
        }
        ans.add(uf.getCount());
   }
   return ans;
}

class UnionFind {
    int count;
    int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
    }
    public void add(int id) {
        parent[id] = id;
        count++;
    }
    public void union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);
        if (iParent != jParent) {
            parent[iParent] = jParent;
            count--;
        }
    }
    private int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
    public int getCount() {
        return count;
    }
}
