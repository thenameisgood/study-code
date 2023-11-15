package org.example.queue;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/10/13 13:55
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(222);
        arrayQueue.addQueue(333);
        arrayQueue.addQueue(444);

        arrayQueue.removeQueue();

        int i = arrayQueue.headQueue();
        System.out.println(i);



        //环形队列
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void addQueue(int i) {
        if (ifFull()) {
            System.out.println("队列已经满了");
        }
        rear++;
        arr[rear] = i;
    }

    public int removeQueue() {
        if (ifEmpty()) {
            System.out.println("队列已经为空");
        }
        front++;
        return arr[front];
    }

    public void show() {
        if (ifEmpty()) {
            System.out.println("队列为空");
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public int headQueue() {
        if (ifEmpty()) {
            System.out.println("队列为空");
        }
        return arr[front + 1];
    }

    public boolean ifFull() {
        return rear == maxSize - 1;
    }

    public boolean ifEmpty() {
        return rear == front;
    }
}


class CircleArrayQueue {
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数据用于存放数据，模拟队列
    private int[] arr;

    //创建队列
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public void addQueue(int i) {
        if (ifFull()) {
            System.out.println("队列已经满了");
        }
        arr[rear] = i;
        rear = (rear + 1) % maxSize;
    }

    public int removeQueue() {
        if (ifEmpty()) {
            System.out.println("队列已经为空");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void show() {
        if (ifEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (ifEmpty()) {
            System.out.println("队列为空");
        }
        return arr[front];
    }

    public boolean ifFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean ifEmpty() {
        return rear == front;
    }
}
