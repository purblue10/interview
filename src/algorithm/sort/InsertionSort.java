package algorithm.sort;

/**
 * Created by purblue on 6/7/16.
 */
public class InsertionSort {
    public static void insertionSort(int[] arr)
    {
        for(int i=1; i<arr.length; i++){
            int x = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]> x){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = x;
        }
    }

    public static void main(String[] args){

        int[] arr = {1,4,3,5,6,2, 2, 3, 6};
        InsertionSort.insertionSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
