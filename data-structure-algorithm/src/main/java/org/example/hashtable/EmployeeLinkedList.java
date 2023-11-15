package org.example.hashtable;

/**
 * @author: ht
 * @date: 2022/10/15 20:31
 */
public class EmployeeLinkedList {
    //头指针
    private Employee head;

    public void add(Employee employee) {
        //如果是第一个
        if (head == null) {
            head = employee;
            return;
        }
        //如果不是第一个
        Employee curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时，将curEmp加入链表
        curEmp.next = employee;
    }

    public void list() {
        if (head == null) {
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表信息为：");
        Employee curEmp = head;
        while (true) {
            System.out.println(curEmp);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Employee findEmployeeById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                System.out.println("遍历完成，但没有找到");
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

