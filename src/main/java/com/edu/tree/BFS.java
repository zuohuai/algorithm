package com.edu.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索
 */
public class BFS {


    @Test
    public void testBFs() throws Exception{
        TreeNode rootNode = TreeNode.buildTree();
        List<String> resultList = bfs(rootNode);
        System.out.println(JSON.toJSONString(resultList));
    }


    public List<String> bfs(TreeNode treeNode) throws Exception{
        List<String> resultList = new ArrayList<>();

        //1. 参数校验
        if(treeNode == null){
            return resultList;
        }

        //2. 定义队列
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(treeNode);

        //3. 层次遍历
        while(!nodeQueue.isEmpty()){
            int levelSize = nodeQueue.size();
            //按照层次遍历
            for(int i=0; i<levelSize; i++){
                treeNode = nodeQueue.poll();
                resultList.add(treeNode.value);
                // 增加左节点
                if(treeNode.left != null){
                    nodeQueue.add(treeNode.left);
                }

                // 增加右节点
                if(treeNode.right != null){
                    nodeQueue.add(treeNode.right);
                }
            }

        }
        return resultList;
    }

    @Test
    public void testMaxDepth() throws Exception{
        TreeNode rootNode = TreeNode.buildTree();
        System.out.println(maxDepth(rootNode));
    }

    /**
     *给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int maxDept = 0;
        if(root == null){
            return maxDept;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            // 将该层的所有节点全部弹出
            int levelSize = nodeQueue.size();
            for(int i=0; i < levelSize; i++){
                root = nodeQueue.poll();

                TreeNode left = root.left;
                TreeNode right = root.right;
                if(left != null){
                    nodeQueue.add(left);
                }

                if(right != null){
                    nodeQueue.add(right);
                }
            }
            //累加最大深度
            maxDept++;
        }
       return maxDept;
    }

    @Test
    public void testMinDepth() throws Exception{
        TreeNode rootNode = TreeNode.buildTree();
        System.out.println(minDepth(rootNode));
    }
    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最小深度  2.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root == null){
            return 0;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            int levelSize = nodeQueue.size();
            minDepth++;
            for(int i =0; i<levelSize; i++){
                root = nodeQueue.poll();
                TreeNode left = root.left;
                TreeNode right = root.right;
                if(left == null && right == null){
                    return minDepth;
                }
                if(left != null){
                    nodeQueue.offer(left);
                }
                if(right != null){
                    nodeQueue.offer(right);
                }
            }
        }
        return minDepth;
    }
}
