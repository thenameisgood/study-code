package org.example.stack;

/**
 * @Description: 计算器
 * @Author: ht
 * @Date: 2022/10/14 10:05
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "1+2*20/20";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        char oper;
        int result = 0;
        char ch = ' ';
        //用于拼接多位数
        String keepNum = "";
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    if (operStack.pri(ch) <= operStack.pri(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = (char) operStack.pop();
                        result = operStack.calculate(num1, num2, oper);
                        numStack.push(result);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                }
            } else {
                //numStack.push(ch - 48);
                //处理多位数
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = (char) operStack.pop();
            result = operStack.calculate(num1, num2, oper);
            numStack.push(result);
        }
        System.out.println("结果" + numStack.pop());
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public int peek() {
        return stack[top];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
        }

        while (true) {
            System.out.println(stack[top]);
            top--;
            if (top == -1) {
                break;
            }
        }
    }

    //优先级
    public int pri(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int calculate(int num1, int num2, char oper) {
        int result = 0;

        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }

        return result;
    }

}

