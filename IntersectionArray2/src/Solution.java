import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishaoxun on 2016/6/29.
 */
public class Solution {

    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i : nums1){
            list1.add(i);
        }

        for(int j : nums2){
            if(list1.contains(j)){
                list2.add(j);
                list1.remove(list1.indexOf(j));
                System.out.println("list1 = "+list1);
            }
        }
        int i = 0;
        int[] result = new int[list2.size()];
        for(Integer x : list2){
            result[i++] = x;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,1};
        int[] nums2 = {1,1};
        int[] result = intersect(nums1,nums2);
        for(int r : result){
            System.out.print(r+" ");
        }
    }
}
