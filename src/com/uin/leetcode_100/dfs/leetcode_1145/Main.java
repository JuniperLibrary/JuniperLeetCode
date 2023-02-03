package com.uin.leetcode_100.dfs.leetcode_1145;

public class Main {
    private int x, lsz, rsz;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 1145. 二叉树着色游戏
        // 两位极客玩家
        // 给出二叉树的root节点，树上总共有n个节点，n为奇数
        // [一号]玩家从[1,n]中取出 x（1<=x<=n）
        // [二号]玩家也从[1,n]中取出一个值 y(1<=y<=n),且y!=x.

        // [一号]先手给值x的节点染上红色。[二号]给y的节点染上蓝色。
        // 之后轮流操作。每一回合，玩家选择选择被他染过颜色的节点，将所选节点的未着色的领节点（左右或者福节点）进行染色。
        // [一号]玩家选择红色.[二号玩家选择蓝色]
        // 如果无法找到这样的节点就跳过。

        // 若两个玩家都没有可以染色的节点，游戏结束。
        // 着色节点最多的选手获得胜利。

        // 现在假设 你是[二号]玩家，根据所给出的输入，加入存在一个y值可以确保你赢得这场游戏，则返回true。

        // 解题思路：哪颗子树最大 y就选哪个
        // 设n2 为2号玩家最多可以染的节点个数，左子树的大小lsz，右子树的大小为rsz。
        // 那么父节点子树的大小就是n-1-lsz-rsz
        // 因此 n2=max(lsz,rsz,n-1-lsz-rsz);
        // 一号玩家染的节点个数 n-n2，获胜的条件为n2>n-n2。即2 * n2 > n;

        this.x = x;
        dfs(root);
        return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ls = dfs(root.left);
        int rs = dfs(root.right);
        if (root.val == x) {
            lsz = ls;
            rsz = rs;
        }
        return ls + rs + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
