// https://www.lintcode.com/problem/graph-valid-tree/description

// https://www.geeksforgeeks.org/disjoint-set-data-structures/

public class Solution {
    
    // Complexity : N*E(Node * Edges) [Can be optimized to union find by rank to Log(n)]

    public boolean validTree(int n, int[][] edges) {
        int par[] = new int[n];
        
        for(int i = 0; i < n; i++)
            par[i] = i;
            
        int count = 0;
        // implementation of makeUnion() and isUnion() is naive and takes O(n)
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(isUnion(u, v, par)) {
               return false; 
            }
            makeUnion(u, v, par);
            count++;
        }
        return count == n - 1 ? true : false;
    }
    
    int findParent(int i, int par[]) {
        if(i == par[i]) return i;
        return par[i] = findParent(par[i], par);
    }
    
    void makeUnion(int u, int v, int par[]) {
        par[ findParent(u, par) ] = findParent(v, par);
    }
    
    boolean isUnion(int u, int v, int par[]) {
        return par[u] == par[v];
    }
}
