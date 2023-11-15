package org.example.tree;

/**
 * @author: ht
 * @date: 2022/10/15 22:10
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();

        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //手动创建二叉树
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(node1);

//        binaryTree.preOrder();
        binaryTree.infixOrder();
//        binaryTree.postOrder();

        //查找
        System.out.println("查询");
        HeroNode heroNode = binaryTree.preOrderSearch(2);
        System.out.println(heroNode);
    }
}

