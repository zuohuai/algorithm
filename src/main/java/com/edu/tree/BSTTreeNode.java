package com.edu.tree;

/**
 * 二叉搜索树
 */
public class BSTTreeNode {

    public Integer value;

    public BSTTreeNode left;

    public BSTTreeNode right;

    public BSTTreeNode(Integer value){
        this.value = value;
    }


    /**
     * 构建一棵树
     *
      5
     /  \
     1   4
         / \
        3   6
     [5,1,4,null,null,3,6]
     [10,5,15,null,null,6,20]
     * @return
     */
    public static BSTTreeNode buildTree(){
        BSTTreeNode tree10 = new BSTTreeNode(10);
        BSTTreeNode tree5= new BSTTreeNode(5);
        BSTTreeNode tree15 = new BSTTreeNode(15);
        BSTTreeNode tree6 = new BSTTreeNode(6);
        BSTTreeNode tree20 = new BSTTreeNode(20);

        tree10.left = tree5;
        tree10.right = tree15;
        tree15.left = tree6;
        tree15.right = tree20;
        return tree10;
    }
}
