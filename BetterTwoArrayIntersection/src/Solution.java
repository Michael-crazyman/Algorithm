import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lishaoxun on 2016/6/29.
 */
public class Solution {


    /**
     *
     *
     * This is a better answer for two array intersection.
     * @param nums1
     * @param nums2
     * @return
     */

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list1 = new ArrayList<>();
//        for(int i = 0,j = 0;i < nums1.length && j < nums2.length ;){
//            if(nums1[i] == nums2[j]){
//                list1.add(nums1[i]);
//                i++;
//                j++;
//            }else if(nums1[i] > nums2[j]){
//                j++;
//            }else{
//                i++;
//            }
//        }
        //for or while you can use any one.Just for fun！
        int i = 0,j = 0;
        while(i < nums1.length && j < nums2.length ){
            if(nums1[i] == nums2[j]){
                list1.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] result = new int[list1.size()];
        int n = 0;
        for(int x : list1){
            result[n++] = x;
        }

        return result;
    }
}
