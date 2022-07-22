//package com.uin.tree.bfs;
//
//import com.uin.tree.foreach.TreeNode;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
///**
// * 广度优先遍历-层序遍历
// * <p>
// * 其过程检验来说是对每一层节点依次访问，访问完一层进入下一层，而且每个节点只能访问一次
// *
// * @author wanglufei
// * @date 2022/7/18 10:26 AM
// */
//public class Main {
//    public static void main(String[] args) {
//
//    }
//
//    public static List<Integer> bfs(TreeNode1 root) {
//        Queue<TreeNode1> queue = new LinkedList<>();
//        List<Integer> list = new LinkedList<>();
//
//        if (root == null) return list;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            //将队列的头部的元素拿出来
//            TreeNode1 tree = queue.remove();
//            if (tree.left != null) queue.add(tree.left);
//            if (tree.right != null) queue.add(tree.right);
//            list.add(tree.val);
//        }
//        return list;
//    }
//}
//
//class TreeNode1 {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode1() {
//    }
//
//    TreeNode1(int val) {
//        this.val = val;
//    }
//
//    TreeNode1(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
