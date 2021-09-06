package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumDepthOfBinaryTree_solve {

    // Dfs_stack 질문받고 난 뒤에 해설
    public static void main(String[] args) {

        MaximumDepthOfBinaryTree_solve a = new MaximumDepthOfBinaryTree_solve();

        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);

        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);

        node.left.right = new TreeNode(5);

        node.left.left.left = new TreeNode(6);

        System.out.println("val: " + a.dfs(node));

        System.out.println("val: " + a.dfsStack(node));

    }

    public List<Integer> dfsStack(TreeNode root) {

        List<Integer> lists = new ArrayList<>();

        if (root == null)

            return lists;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode tree = stack.pop();

            if (tree.right != null)

                stack.push(tree.right);

            if (tree.left != null)

                stack.push(tree.left);

            lists.add(tree.val);

        }

        return lists;

    }

    public int dfs(TreeNode root) {

        // 1

        if (root == null)

            return 0;

        Stack<TreeNode> stack = new Stack<>();

        Stack<Integer> valueStack = new Stack<>();

        stack.push(root);

        valueStack.push(1);

        int max = 0;

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

// System.out.println("node: " + node.val);

            int count = valueStack.pop();

            max = Math.max(max, count);

            if (node.left != null) {

                stack.push(node.left);

                valueStack.push(1 + count);

            }

            if (node.right != null) {

                stack.push(node.right);

                valueStack.push(1 + count);

            }

        }

        return max;

    }

}
