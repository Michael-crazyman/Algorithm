/**
 * Created by lishaoxun on 2016/6/10.
 */
import java.util.*;
public class MyStack {
    public Stack<Integer> getStack() {
        return stack;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    private Stack<Integer> stack;
    public MyStack(){
        this.stack = new Stack<Integer>();
    }

    public static int getAndRemoveElements(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveElements(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return ;
        }
        int i = getAndRemoveElements(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void reverse2(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        System.out.println(stack.pop());
        reverse2(stack);
    }

    public static void main(String[] args){
        MyStack stack = new MyStack();
        Stack<Integer> stack1 = stack.getStack();
        int[] data = new int[10];
        for(int i = 0;i < 10;i++){
            data[i] = i;
        }
        for(int i = 0; i<data.length;i++){

            stack1.push(data[i]);
        }

        reverse2(stack1);
        /*while(!stack1.isEmpty()){
            System.out.print(stack1.pop());
        }*/



    }
}
