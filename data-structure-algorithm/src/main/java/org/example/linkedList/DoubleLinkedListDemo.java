package org.example.linkedList;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/10/13 20:14
 */
public class DoubleLinkedListDemo {
}

class DoubleLinkList {
    //初始化一个头节点
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead(){
        return head;
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
