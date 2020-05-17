import java.util.Stack;

public class 最小栈 {

    class MinStack {

        Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        // 入栈的时候，记录当前最小值，并压入栈中，然后再压入当前值
        // 最小的元素永远放在顶上
        // []
        // push 2 -> [2]
        // push 1 -> [1, 2]
        // push 3 -> [3, 1, 2]
        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                stack.push(x);
                return;
            }

            // 栈不为空
            int min = stack.peek();
            int newMin = min < x ? min : x;
            stack.push(x);
            stack.push(newMin);
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            // 栈顶是当前最小
            int min = stack.peek();
            // 先推出
            stack.pop();
            // 现在是真正的栈顶
            int top = stack.peek();
            // 把最小压回去
            stack.push(min);
            return top;
        }

        public int getMin() {
            return stack.peek();
        }
    }

}