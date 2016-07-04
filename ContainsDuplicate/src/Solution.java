import java.util.HashSet;

/**
 * Created by lishaoxun on 2016/7/4.
 */
public class Solution {


    /**
     *
     * 此方法已被leetcode验证过，并且已被accepted！
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        if(nums == null){
            return false;
        }
        //使用一个hashset来存储访问到当前节点的时候只出现过一次的数
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){
            if(!set.contains(i)){
                set.add(i);
            }else{
                return true;
            }
        }

        return false;
    }
}
