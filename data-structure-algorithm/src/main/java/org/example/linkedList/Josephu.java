package org.example.linkedList;

/**
 * @Description: 约瑟夫环问题 单向环形链表
 * @Author: ht
 * @Date: 2022/10/13 20:50
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1, 3, 5);
    }
}

class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = null;

    //添加小孩节点 构建成一个环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums值不对");
            return;
        }
        //辅助指针
        Boy curBoy = null;
        //使用for循环创建链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy.getNo());
            if (curBoy.getNext() == first) {
                System.out.println("遍历完成");
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    //从第几个开始数；数几下；最初有多少小孩在圈中
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有问题");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //从第几个开始数
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //first出圈
            System.out.println("出圈："+first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最终留下来的小孩是："+first.getNo());
    }

}


class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

