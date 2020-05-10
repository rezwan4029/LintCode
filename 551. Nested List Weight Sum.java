// https://www.lintcode.com/problem/nested-list-weight-sum/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> Q = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        for(NestedInteger ni: nestedList) {
            Q.add(ni);
            D.add(1);
        }
        int Ans = 0;
        while(!Q.isEmpty()) {
            NestedInteger item = Q.poll();
            int depth = D.poll();
            if(item.isInteger()) {
                Ans += (depth * item.getInteger());
            } else {
                for(NestedInteger ni: item.getList()) {
                    Q.add(ni);
                    D.add(depth + 1);
                }
            }
        }
        return Ans;
    }
    
}
