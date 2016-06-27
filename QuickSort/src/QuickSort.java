public class QuickSort{

    private static int[] array = {2,8,3,666,1,5,4,9};

    public static void quickSort(int left, int right){

        if(left > right){
            return;
        }
        int leftPivot ,rightPivot;
        leftPivot = left;
        rightPivot = right;
        int temp = array[left];
        while (leftPivot < rightPivot){
            while((leftPivot < rightPivot) && (array[rightPivot]>=temp)){
                rightPivot--;
            }

            while((leftPivot < rightPivot) && (array[leftPivot] <= temp)){
                leftPivot++;
            }

            if(leftPivot < rightPivot){
                array = swap(leftPivot,rightPivot,array);
            }

        }
        array[left] = array[leftPivot];
        array[leftPivot] = temp;

        for(int i = 0;i < array.length;i++){
            System.out.print(array[i]+"  ");
        }
        quickSort(left,leftPivot-1);
        quickSort(leftPivot+1,right);
    }

    public static int[] swap(int left,int right,int[]array){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        return array;
    }

    public static void main(String[] args){
        int length = array.length;
        quickSort(0,length-1);
        System.out.println("Hello World!");
    }
}