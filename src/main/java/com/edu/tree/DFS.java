package com.edu.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索
 */
public class DFS {

    @Test
    public void testDFS() throws Exception{
        TreeNode rootNode = TreeNode.buildTree();
        List<String> resultList = new ArrayList<>();
        dfs(rootNode, resultList);
        System.out.println(resultList);
    }

    /**
     * 深度优先搜索 (本质上还是利用栈的结构来实现)
     * 输出的结果是: H, I, D, J, E, B, K, F, G, C, A]
     * @param treeNode
     * @param resultList
     * @throws Exception
     */
    public void dfs(TreeNode treeNode, List<String> resultList) throws Exception{
        if(treeNode == null){
            return;
        }

        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;

        // 先左节点最底端的元素
        if(left != null){
            dfs(left, resultList);
        }
        // 有节点最底端的元素
        if(right != null){
            dfs(right, resultList);
        }

        //结果到结果集中
        resultList.add(treeNode.value);
    }

    @Test
    public void testMaxDepth() throws Exception{
        TreeNode rootNode = TreeNode.buildTree();
        System.out.println(maxDepth(rootNode));
    }


    /**
     * 最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 计算左子树的深度
        int leftDept = maxDepth(left);
        //计算右子树的深度
        int rightDepth = maxDepth(right);
        return  Math.max(leftDept, rightDepth) + 1;
    }

    @Test
    public void testMinDepth() throws Exception{
        TreeNode rootNode = TreeNode.buildTree();
        System.out.println(minDepth(rootNode));
    }

    /**
     * 最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        //递归终止条件
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 计算左子树的深度
        int leftDept = minDepth(left);
        //计算右子树的深度
        int rightDepth = minDepth(right);
        return  Math.min(leftDept, rightDepth) + 1;
    }
}
