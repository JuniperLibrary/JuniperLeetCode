package main.java.com.uin.td.binratree.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");

        int n = Integer.parseInt(params[0]);
        int rootVal = Integer.parseInt(params[1]);

        // 先建树
        TreeNode root = new TreeNode(rootVal);
        HashMap<Integer, TreeNode> map = new HashMap<>();
        map.put(root.val, root);

        for (int i = 0; i < n; i++) {
            params = br.readLine().split(" ");
            int val = Integer.parseInt(params[0]);
            int leftVal = Integer.parseInt(params[1]);
            int rightVal = Integer.parseInt(params[2]);

            TreeNode node = map.get(val);
            if (leftVal != 0) {
                node.left = new TreeNode(leftVal);
                map.put(leftVal, node.left);
            }
            if (rightVal != 0) {
                node.right = new TreeNode(rightVal);
                map.put(rightVal, node.right);
            }
        }

        int target = Integer.parseInt(br.readLine());

        int prev = -1, res = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();

                if (prev == target) {
                    //前一个节点为询问节点，当前节点为后继节点
                    res = root.val;
                    break;
                }
                prev = root.val;
                root = root.right;
            }
        }
        System.out.println(res);
    }
}
