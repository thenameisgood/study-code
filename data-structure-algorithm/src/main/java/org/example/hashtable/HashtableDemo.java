package org.example.hashtable;

/**
 * @author: ht
 * @date: 2022/10/15 20:29
 */
public class HashtableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        hashTable.add(new Employee(1, "萨达姆"));
        hashTable.add(new Employee(2, "阿萨姆"));
        hashTable.list();
    }
}

class HashTable {
    private EmployeeLinkedList[] employeeLinkedListArray;
    //有多少条链表 也就是数组的长度
    private int size;

    //构造器
    public HashTable(int size) {
        this.size = size;
        employeeLinkedListArray = new EmployeeLinkedList[size];
        //
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee) {
        //根据id，计算散列值
        int empLinkedListNum = hashFunction(employee.id);
        //将employee添加到对应的链表中
        employeeLinkedListArray[empLinkedListNum].add(employee);
    }

    //遍历整个哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i].list();
        }
    }

    public void find(int id) {
        int empLinkedListNum = hashFunction(id);

        Employee employeeById = employeeLinkedListArray[empLinkedListNum].findEmployeeById(id);
        if (employeeById == null){
            System.out.println("没有查找到");
        } else {
            System.out.println(employeeById);
        }
    }

    public int hashFunction(int id) {
        return id % size;
    }
}

