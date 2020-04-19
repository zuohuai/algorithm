package com.edu.tree;

public class TreeNode {

    public String value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(String value){
        this.value = value;
    }


    /**
     * 构建一棵树
     *
     *    A
     * B    C
     * D E  F   G
     * H I  J K
     * @return
     */
    public static TreeNode buildTree(){
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        D.left = H;
        D.right = I;

        E.right = J;

        C.left = F;
        C.right = G;

        F.right = K;
        return A;
    }
}
