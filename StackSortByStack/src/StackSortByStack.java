import java.util.Stack;

/**
 * Created by lishaoxun on 2016/6/10.
 */
public class StackSortByStack {

    public static Stack<Integer> sortByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }

        return stack;
    }


    public static void main(String[] args){
        Stack stack = new Stack<>();
        for(int i = 0;i < 10;i++){
            stack.push(i);
        }

         stack = sortByStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}