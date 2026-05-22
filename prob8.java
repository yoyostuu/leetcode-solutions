class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int[] candidates,
                          int target,
                          int index,
                          List<Integer> current,
                          List<List<Integer>> ans) {

        // Base case
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // If target becomes negative
        if (target < 0) {
            return;
        }

        // Try every candidate from current index
        for (int i = index; i < candidates.length; i++) {

            // Choose
            current.add(candidates[i]);

            // Explore
            // i is passed again because same number can be reused
            backtrack(candidates,
                      target - candidates[i],
                      i,
                      current,
                      ans);

            // Undo choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}