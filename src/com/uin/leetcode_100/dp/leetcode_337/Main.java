package com.uin.leetcode_100.dp.leetcode_337;

import com.uin.leetcode_100.tree.TreeNode;

import java.util.HashMap;

public class Main {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val = val + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val = val + rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }


    public int rob2(TreeNode root) {
        int[] res = robSolution(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSolution(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = robSolution(root.left);
        int[] right = robSolution(root.right);
        //res[0] 不选 不rob
        //res[1] 选 rob

        res[0] = 0 + Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public int rob3(TreeNode root) {
        if (root == null) return 0;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return rob3Solution(root, map);
    }

    private int rob3Solution(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        //
        int res1 = root.val;
        if (root.left != null) {
            res1 += rob3Solution(root.left.left, map) + rob3Solution(root.left.right, map);
        }
        if (root.right != null) {
            res1 += rob3Solution(root.right.left, map) + rob3Solution(root.right.right, map);
        }
        //
        int res2 = 0;
        res2 += rob3Solution(root.left, map) + rob3Solution(root.right, map);

        int res = Math.max(res1, res2);
        map.put(root, res);
        return res;
    }
}
