package data_structure.main;

/**
 * Created by purblue on 6/24/16.
 */
public class BinarySearch {

    public static int binarySearchHepler(int[] arr, int left, int right, int target){
        if(left >= right && arr[left]>target)
            return left;
        if (left >= right)
            return -1;

        int center = (left + right) / 2;
        if(arr[center]==target)
            return center;
        else if(target < arr[center]){
            return binarySearchHepler(arr, left, center - 1, target);
        }else{
            return binarySearchHepler(arr, center + 1, right, target);
        }

    }

    public static int binarysearch(int[] arr, int target){
        return binarySearchHepler(arr, 0, arr.length-1, target);
    }

    public static void main(String[] args){
        int[] arr = {1};

        System.out.println(binarysearch(arr, 1));
        System.out.println(binarysearch(arr, 4));
    }
}
