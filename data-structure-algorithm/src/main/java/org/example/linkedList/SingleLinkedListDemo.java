package org.example.linkedList;

import java.util.Stack;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/10/13 14:09
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟");

        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addByOrder(heroNode1);
        singleLinkList.addByOrder(heroNode3);
        singleLinkList.addByOrder(heroNode2);
        singleLinkList.list();
    }
}

//定义SingleLinkList
class SingleLinkList {
    //初始化一个头节点
    private HeroNode headNode = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = headNode;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //循环结束之后，temp就指向了最后一个节点
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("已存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode heroNode) {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = headNode.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.println("没有找到编号的节点");
        }
    }

    public void delete(int no) {
        HeroNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在");
        }
    }

    //显示链表
    public void list() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        //遍历
        HeroNode temp = headNode.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode node = head.next;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    //倒数第k个
    public static HeroNode lastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);

        if (index <= 0 || index > size) {
            return null;
        }

        HeroNode current = head;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }
        return current;
    }

    public static void reverseNode(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode current = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (current != null) {
            next = current.next;
            current.next = reverseHead.next;
            reverseHead.next = current;
            current = next;
        }
        head.next = reverseHead.next;
    }

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<Object> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

//每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
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

