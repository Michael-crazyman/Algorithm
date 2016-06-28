import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lishaoxun on 2016/6/28.
 */
public class Solution {

    public static int[] intersection(int[] nums1,int[] nums2){

        if(nums1 == null && nums2 != null && nums2.length < 1){
            return nums2;
        }else if(nums1 != null && nums1.length < 1 && nums2 == null){
            return nums1;
        }else if(nums1 == null && nums2 == null){
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0;i < nums1.length;i++)
            set1.add(nums1[i]);
        for(int s : nums2){
            if(set1.contains(s)){
                set2.add(s);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for(Integer s1 : set2)
            result[i++] = s1;

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[1];
        nums1[0] = 1;
        int[] nums2 = new int[0];

        int[] result = intersection(nums1,nums2);
        for(int i = 0;i < result.length;i++){
            System.out.println(result[i]);
        }
    }

}
