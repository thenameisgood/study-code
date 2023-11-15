package org.example.tree;

/**
 * @author: ht
 * @date: 2022/10/15 22:11
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//默认null
    private HeroNode right;//默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 删除
     */
    //删除节点  待验证
//    public void deleteNode(int no) {
//        if (this.left != null && this.left.no == no) {
//            this.left = null;
//            return;
//        }
//        if (this.right != null && this.right.no == no) {
//            this.right = null;
//            return;
//        }
//        if (this.left != null) {
//            this.left.deleteNode(no);
//        }
//        if (this.right != null){
//            this.right.deleteNode(no);
//        }
//    }


    /**
     * 遍历
     */
    //前序遍历的方法
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历的方法
    public void infixOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历的方法
    public void postOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * 查找
     */
    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.infixOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.postOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        return heroNode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

