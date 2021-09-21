package com.leetcode.graph;

/**
 * MaximumDepthOfBinaryTree (DiameterOfBinaryTree?)
 * left, right 호출한다
 * Math.max(leftMax,rightMax)를 이용한다
 * 재귀를 이용해서 풀었고 제일 깊은 곳이 1이 된다. root는 3?
 */

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        //root.left.right = new TreeNode(8);
        //root.left.left.left = new TreeNode(7);
        System.out.println(a.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }

}
