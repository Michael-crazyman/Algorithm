import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishaoxun on 2016/7/5.
 */
public class Solution {

    /**
     *
     * 下述方法已经由leetcode验证，并且已经accepted！
     * @param nums
     * @return
     */

    public int[] singleNumber(int[] nums) {

        if(nums == null){
            return nums;
        }

        Set<Integer> set = new HashSet<>();
        for(Integer x : nums){
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }
        }
        int[] newNums = new int[set.size()];
        int i = 0;
        for(Integer y : set){
            newNums[i++] = y;
        }

        return newNums;

    }
}
