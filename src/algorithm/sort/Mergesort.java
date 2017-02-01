package algorithm.sort;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * My implementation.
 */
public class Mergesort {
    public static void main(String[] args){
        int[] arr = {4,3,7,4,5,8,10};
        mergeSort(arr);
        for(int n:arr)
            System.out.print(n+" ");
    }
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int[] temp, int begin, int end){
        if(begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(arr, temp, begin, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, begin, mid, end);
        }
    }

    public static void merge(int[] arr, int[] temp, int begin, int mid, int end){
        for(int i=begin; i<=end; i++)
            temp[i] = arr[i];

        int i=begin, j=mid+1, idx = begin;

        while(i<=mid && j<=end)
            arr[idx++] = (temp[i] < temp[j]) ? temp[i++] : temp[j++];

        while(i<=mid)
            arr[idx++] = temp[i++];
    }


}
