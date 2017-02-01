package algorithm.sort;

import java.util.Random;

/**
 * Created by purblue on 6/7/16.
 */
public class QuickSort {

    public void quickSort(int[] arr, int low, int high){
        if(high <= low)
            return;
        int j = hoare_partition(arr, low, high);
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }

    public int hoare_partition(int[] arr, int low, int high){
        random_pivot(arr, low, high);
        int p = arr[low];
        int i=low, j=high+1;
        while(true){
            while (arr[++i] <  p)
                if (i == high) break;

            while (arr[--j] > p)
                if (j == low) break;

            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    public int random_pivot(int[] arr, int low, int high){
        Random rand = new Random();
        int p_idx = rand.nextInt(high-low+1)+low;
        swap(arr, low, p_idx);
        return arr[p_idx];
    }

    public void printArr(int[] arr){
        printArr(arr, 0, arr.length-1, null);
    }

    public void printArr(int[] arr, int low, int high, String str){
        for(int i=low; i<=high; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(str);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        QuickSort sort = new QuickSort();
        int[] arr = {41,37,44,24,39,42,48,1,35,38,40,43,46,49,0,2,30,36,45,47,4,29,32,3,9,26,31,34,7,11,25,27,33,6,8,10,16,28,5,15,19,12,18,20,13,17,22,14,21,23};
        sort.quickSort(arr, 0, arr.length-1);
        sort.printArr(arr);
    }

}
