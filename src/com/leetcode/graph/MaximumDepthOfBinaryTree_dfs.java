package com.leetcode.graph;

import java.util.Stack;

/**
 * MaximumDepthOfBinaryTree (DiameterOfBinaryTree?)
 * left, right 호출한다
 * Math.max(leftMax,rightMax)를 이용한다
 * 재귀를 이용해서 풀었고 제일 깊은 곳이 1이 된다. root는 3?
 */

public class MaximumDepthOfBinaryTree_dfs {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree_dfs a = new MaximumDepthOfBinaryTree_dfs();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        //System.out.println("val: "+a.bfs(node));
        System.out.println("val: "+a.dfs(node));
    }

    public int dfs(TreeNode root) {
        if(root ==null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max=0;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println("node: "+node.val);
            int count =     value.pop();
            max =Math.max(max, count);
            if(node.left !=null) {
                stack.push(node.left);
                value.push(count+1);
            }
            if(node.right !=null) {
                stack.push(node.right);
                value.push(count+1);
            }
        }
        return max;
    }

}
