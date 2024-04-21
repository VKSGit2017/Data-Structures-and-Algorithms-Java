/*
1971. Find if Path Exists in Graph - Easy
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
https://leetcode.com/problems/find-if-path-exists-in-graph/description/
*/



/*
Let n be the number of nodes and m be the number of edges.

Time complexity: O(n+m)

In typical DFS search, the time complexity is O(V+E) where V,E are the number of vertices and edges. More specifically, there are n nodes and m edges in this problem:
We build adjacent list of all m edges in graph which takes O(m).
Each node is only visited once, it takes O(n) to traverse all nodes.
The overall time complexity is O(n+m).
Space complexity: O(n+m)

We use a hash map to store m edges, which takes O(m) space.
We use a bool array seen to keep track of the visited nodes, which requires O(n) space.
The recusive function takes O(n) space.
Therefore, the overall space complexity is O(n+m).
*/


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap();
        boolean valid[] = new boolean[n];

        for(int[] edge: edges){
            adjList.computeIfAbsent(edge[0], value -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], value -> new ArrayList<>()).add(edge[0]);
        }

        return dfs(adjList, valid, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> adjList, boolean[] valid,  int curNode, int destination) {
        if(curNode == destination) return true;
        if(!valid[curNode]){
            valid[curNode] = true;
            for(int nextNode : adjList.get(curNode)){
                if(dfs(adjList, valid, nextNode, destination)){
                    return true;
                }
            }
        }
        return false;    
    }
}
