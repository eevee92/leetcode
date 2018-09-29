UnionFind

Disjoint-set data structure: a set of elements partitioned into a number of disjoint (non-overlapping) subsets.

Union-Find algorithm: perform two useful operations on disjoint-set:
(1) Find:   Determine which subset a particular element is in.
(2) Union:  Join two subset into a single subset.

Optional Operations:
(1) Add:    It's not a must to call Add operation when the graph is static.
    Given that `count` is the number of groups in graph:
    <1> If the components are given dymanically, we need to call Add. So `count` is 0 initially. Add will +1 to count.
    <2> If the components is already given at the beginning, we can directly set `count` to N at initial time.


Optional varaibles:
(1) size of each group: 
    int[] size = new int[N], initial value is all 1. 
    can return size in Union if needed.
    sample: leetcode 128.

Check whether an undirected graph contains cycle or not:

