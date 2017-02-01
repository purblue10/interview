package data_structure.etc;

/**
 * Created by purblue on 5/31/16.
 */
public class Interval {



    public static void main(String[] args){
//        String s = "the sky";
        String s = "abc ades";
        System.out.println(new String(s.toCharArray(), 0, 3));
//        System.out.println("|"+reverseWords(s)+"|");

    }

    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        //swap whole string
        swap(arr, 0, n-1);
        StringBuilder sb = new StringBuilder();
        // Swap each word
        int i=0, j=0;
        int cnt=0;
        while(i<n){
            while(i<n && arr[i]==' ') i++;
            j = i;
            while(j<n && arr[j]!=' ') j++;
            System.out.println(i+":"+j);
            swap(arr, i, j-1);

            if(i<j)
                cnt += (cnt==0)? j-i:j-i+1;
            i=j;
        }

        char[] output = new char[cnt];
        i=0;
        int idx = 0;
        System.out.println(cnt);
        while(i<n){
            while(i<n && arr[i]==' ') i++;
            j = i;
            while(j<n && arr[j]!=' ') j++;

            if(idx!=0 && i<j)
                output[idx++]=' ';
            while(i<j){
                output[idx++] = arr[i++];
            }
        }

        return new String(output);
    }



    public static void swap(char[] arr, int i, int j){
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
}
