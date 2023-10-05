package main.java.com.uin.td.binratree;
/**
 * 在二叉树中找到一个节点的后继节点
 *
 * @author wanglufei
 * @date 2022/8/11 7:13 PM
 */
// * 10 6
// * 6 3 9
// * 3 1 4
// * 1 0 2
// * 2 0 0
// * 4 0 5
// * 5 0 0
// * 9 8 10
// * 10 0 0
// * 8 7 0
// * 7 0 0
// * 10


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /**
         * 二叉树节点的个数
         */
        int n = in.nextInt();
        /**
         * 二叉树根节点
         */
        TreeNode head = constructTree(in, n);
        /**
         * 要询问的节点
         */
        int target = in.nextInt();

    }

    public static TreeNode constructTree(Scanner in, int n) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int rootValue = in.nextInt();
        TreeNode root = new TreeNode(rootValue);
        map.put(rootValue, root);
        for (int i = 0; i < n; i++) {
            int nodeValue = in.nextInt();
            int leftValue = in.nextInt();
            int rightValue = in.nextInt();

            if (map.containsKey(nodeValue)) {
                TreeNode tmp = map.get(nodeValue);
                TreeNode left = leftValue == 0 ? null : new TreeNode(leftValue);
                TreeNode right = rightValue == 0 ? null : new TreeNode(rightValue);
                tmp.left = left;
                tmp.right = right;
                if (leftValue != 0) map.put(leftValue, left);
                if (rightValue != 0) map.put(rightValue, right);
            }
        }
        return root;
    }

    public static TreeNode helper(TreeNode root, int target) {
        if (root == null) return null;

        TreeNode cur = root;
        TreeNode res = null;
        boolean flag = false;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (cur.val == target || flag == true) {
                if (flag == true) {
                    res = cur;
                    break;
                }
                flag = true;
            }
            cur = cur.right;
        }
        return res;
    }



}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
