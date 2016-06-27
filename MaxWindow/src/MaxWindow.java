import java.util.LinkedList;

/**
 * Created by lishaoxun on 2016/6/11.
 */
public class MaxWindow {

    public static int[] getMaxWindow(int[] arr,int w){
        int index = 0;
        int[] res = new int[arr.length-w+1];
        LinkedList<Integer> qMax = new LinkedList<>();
        for(int i = 0;i < arr.length;i++){
            while(!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]){
                qMax.pollLast();
            }
            qMax.addLast(i);

            if(qMax.peekFirst() == i - w){
                qMax.pollFirst();
            }

            if(i >= w-1){
                res[index++] = arr[qMax.pollFirst()] ;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] res = {4,3,5,4,3,3,6,7};
        int w = 3;
        int[] arr = getMaxWindow(res,w);
        for(int i = 0;i < arr.length; i++ ){
            System.out.print(arr[i]+" ");
        }
    }


}
