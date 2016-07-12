/**
 * Created by lishaoxun on 2016/7/12.
 */
public class Solution {

    /**
     *
     * 已经在leetcode上验证过，并且已经accepted！
     * 后续会补充isPowerOfTwo和isPowerOfThree
     * @param num
     * @return
     */

    public boolean isPowerOfFour(int num){

        if(num == 1){
            return true;
        }else if(num == 0){
            return false;
        }else if(num % 4 == 0){
            return isPowerOfFour(num / 4);
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(12));
    }
}
