import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishaoxun on 2016/6/28.
 */
public class RadixSort {

    public int[] radixSort(int[] A, int n) {

        int index = 1;
        for(int i = 0;i < n;i++){
            int tmpLength = Integer.toString(A[i]).length();
            if(index < tmpLength)
                index = tmpLength;
        }

        return radixSort(A,0,index);

    }

    public int[] radixSort(int[] arr,int exponent,int index){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0;i < 10;i++){
            list.add(new ArrayList<Integer>());
        }
        int length = arr.length;
        for(int i = 0;i < length;i++){
            int num = 0;
            int digitNum;
            String str = Integer.toString(arr[i]);
            digitNum = str.length()-exponent-1;
            if( digitNum >= 0)
                num = Integer.parseInt(str.substring(digitNum,str.length()-exponent));
            list.get(num).add(arr[i]);
        }

        int size = list.size();
        for(int i = 0,k = 0;i < size;i++){
            int size1 = list.get(i).size();
            for(int j = 0;j < size1;j++){
                arr[k++] = list.get(i).get(j);
            }
        }

        if(index == ++exponent)
            return arr;
        else
            return radixSort(arr,exponent,index);
    }
}
