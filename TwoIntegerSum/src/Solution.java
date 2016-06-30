/**
 * Created by lishaoxun on 2016/6/30.
 */
public class Solution {

    public static int getSum(int a,int b){
        int carry, add;
        do {
            add = a ^ b; //该操作得到本位的加法结果
            carry = (a & b) << 1; //该操作得到该位对高位的进位值
            a = add;
            b = carry;
        } while (carry != 0); //循环直到某次运算没有进位，运算结束
        return add;
    }

    public static void main(String[] args) {
        int sum = getSum(9,1);
        System.out.println(sum);
    }
}
