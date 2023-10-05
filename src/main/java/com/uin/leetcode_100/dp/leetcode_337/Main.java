package main.java.com.uin.leetcode_100.dp.leetcode_337;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.HashMap;
/**
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 *
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
 *
 */
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
