package org.example.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/10/14 12:54
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 +";
        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        System.out.println(calculate(list));
    }

    //将一个逆波兰表达式，一次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] s = suffixExpression.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (String s1 : s) {
            strings.add(s1);
        }
        return strings;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<String>();

        for (String s : list) {
            if (s.matches("-?[1-9]\\d*")) {
                stack.push(s);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (s.equals("+")) {
                    result = num1 + num2;
                } else if (s.equals("-")) {
                    result = num1 - num2;
                } else if (s.equals("*")) {
                    result = num1 * num2;
                } else if (s.equals("/")) {
                    result = num1 / num2;
                }
                stack.push(" " + result);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

