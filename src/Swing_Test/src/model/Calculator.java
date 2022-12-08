package Swing_Test.src.model;

import java.util.Stack;

public class Calculator {
    public String calculate(String input) throws RuntimeException {                //计算函数
        String[] comput = input.strip().split(" ");
        Stack<Double> stack = new Stack<>();
        Double m = Double.parseDouble(comput[0]);
        stack.push(m);                                        //第一个操作数入栈

        for (int i = 1; i < comput.length; i++) {
            if (i % 2 == 1) {
                if (comput[i].equals("+"))
                    stack.push(Double.parseDouble(comput[i + 1]));
                if (comput[i].equals("-"))
                    stack.push(-Double.parseDouble(comput[i + 1]));
                if (comput[i].equals("*")) {                    //将前一个数出栈做乘法再入栈
                    Double d = stack.peek();                //取栈顶元素
                    stack.pop();
                    stack.push(d * Double.parseDouble(comput[i + 1]));
                }
                if (comput[i].equals("/")) {                    //将前一个数出栈做乘法再入栈
                    double help = Double.parseDouble(comput[i + 1]);
                    if (help == 0)
                        throw new RuntimeException("Infinity");            //不会继续执行该函数
                    double d = stack.peek();
                    stack.pop();
                    stack.push(d / help);
                }
            }
        }

        double d = 0d;

        while (!stack.isEmpty()) {            //求和
            d += stack.peek();
            stack.pop();
        }

        String result = String.valueOf(d);
        return result;
    }

}
