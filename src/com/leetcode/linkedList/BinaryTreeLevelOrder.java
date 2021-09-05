package com.leetcode.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 문제에서 보통 TreeNode 구조를 제공해 준다.
 */
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Queue 자료 구조를 이용하여야 한다.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrder {

    /**
     * input 트리 구조    1
     *                2   3
     *              4  5
     * output [[1], [2,3] , [4,5] ]
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        solve(root);
    }

    public static List<List<Integer>> solve(TreeNode root) {
        //1 ds
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //2 for, while add algo
        // Queue는 보통 끝까지 빼기 때문에 while문 사용하는 것이 바람직하다.
        while (!queue.isEmpty()) { // 2번 째엔 2,3이 있고 queue size가 2가 될 것임
            int size = queue.size(); // 1
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val); // 1

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
