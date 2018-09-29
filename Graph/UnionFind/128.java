
public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    // map unique val to an id (0 based), id will be used as the id in union find
    Map<Integer, Integer> map = new HashMap();
    // help map to create the 0 based id
    List<Integer> list = new ArrayList();
    
    for (int num : nums) {
        // avoid duplicate
        if (map.containsKey(num)) {
            continue;
        }
        map.put(num, list.size());
        list.add(num);
    }

    int ans = 1;

    // number of unique values
    int N = list.size();
    UnionFind uf = new UnionFind(N);
    for (int num : list) {
        int id = map.get(num);
        // the "edge" is "num + 1"
        if (map.containsKey(num + 1)) {
            int id2 = map.get(num + 1);
            ans = Math.max(ans, uf.union(id, id2));
        }
    }
    return ans;
}

class UnionFind {
    int count;
    int[] parent;
    int[] size;
    UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    // return size of a group after union
    int union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);
        if (iParent == jParent) {
            return size[iParent];
        } else {
            count--;
            size[iParent] += size[jParent];
            parent[jParent] = iParent;
            return size[iParent];
        }
    }
    int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
}
