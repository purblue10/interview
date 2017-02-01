package algorithm.sort;

/**
 * Count inversion. 
 * http://www.geeksforgeeks.org/counting-inversions/
 */
public class CountInversion {
    public static void main(String[] args){
        int[] arr = {1,2,0};
        System.out.println("Number of inversion:" + inversionCounter(arr));
        for(int n:arr)
            System.out.print(n+" ");
    }
    public static int inversionCounter(int[] arr){
        int[] temp = new int[arr.length];
        return inversionCounter(arr, temp, 0, arr.length-1);
    }

    public static int inversionCounter(int[] arr, int[] temp, int begin, int end){
        int inversion = 0;
        if(begin < end) {
            int mid = (begin + end) / 2;
            inversion += inversionCounter(arr, temp, begin, mid);
            inversion += inversionCounter(arr, temp, mid + 1, end);
            inversion += merge(arr, temp, begin, mid, end);
        }
        return inversion;
    }

    public static int merge(int[] arr, int[] temp, int begin, int mid, int end){
        for(int i=begin; i<=end; i++){
            temp[i] = arr[i];
        }

        int i = begin, j = mid + 1, idx = begin;
        int inversion = 0;
        while(i<=mid && j<=end){
            if(temp[i] <= temp[j]){
                arr[idx++] = temp[i++];
            }else{
                arr[idx++] = temp[j++];
                inversion += mid - i + 1;
            }
        }

        while(i <= mid){
            arr[idx++] = temp[i++];
        }

        return inversion;
    }
}
