// https://www.lintcode.com/problem/nested-list-weight-sum-ii/description

// https://www.programcreek.com/2014/08/leetcode-nested-list-weight-sum-ii-java/

public class Solution {
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Stack<NestedInteger> Stk = new Stack<>();
        Stack<Integer> D = new Stack<>();
        HashMap<Integer, List<Integer> > data = new HashMap<>();
        for(NestedInteger item: nestedList) {
            Stk.add(item);
            D.add(1);
        }
        int maxDepth = 0;
        while(Stk.size() > 0) {
            NestedInteger item = Stk.pop();
            Integer depth = D.pop();
            maxDepth = Math.max(maxDepth, depth);
            if(item.isInteger()) {
                List<Integer> levelData = data.getOrDefault(depth, new ArrayList<>());
                levelData.add(item.getInteger());
                data.put(depth, levelData);
            } else {
                for(NestedInteger x: item.getList()) {
                    Stk.add(x);
                    D.add(depth + 1);
                }
            }
        }
        int Ans = 0;
        for(int d = 1; d <= maxDepth; d++) {
            for(Integer item: data.getOrDefault(d, new ArrayList<>())) {
                Ans += (item * (maxDepth - d + 1));
            }
        }
        return Ans;
    }
}
