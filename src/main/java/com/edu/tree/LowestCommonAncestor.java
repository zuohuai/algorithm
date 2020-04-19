package com.edu.tree;

import org.junit.Test;

/**
 * 最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class LowestCommonAncestor {

    @Test
    public void testLowestCommonAncestor() throws Exception{

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p==root || q==root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //3. 返回结果
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
