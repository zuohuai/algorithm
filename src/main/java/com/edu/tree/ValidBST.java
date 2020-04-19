package com.edu.tree;


import org.junit.Test;

/**
 * 验证是否是二叉搜索树
 * 所有的左子树都要小于根
 */
public class ValidBST {

    @Test
    public void testIsValidBST() throws Exception{
        BSTTreeNode bstTreeNode = BSTTreeNode.buildTree();
        System.out.println(isValidBST(bstTreeNode));
    }


    /**
     * 利用中序遍历的方式解决
     * 采用中序遍历,一定是一个升序的数据
     * @param root
     * @return
     */
    public boolean isValidBST(BSTTreeNode root) {
        return inOrder(root);
    }

    private BSTTreeNode pre = null;

    private boolean inOrder(BSTTreeNode root){
        if(root == null){
            return true;
        }
        // 左子树 -> 根 -> 右子树
        // 左子树
        if(!inOrder(root.left)){
            return false;
        }

        if(pre != null && pre.value >= root.value){
            return false;
        }

        // 根
        pre = root;

        // 右子树
        return inOrder(root.right);

    }

}
