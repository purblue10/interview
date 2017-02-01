package groupon;

/**
 * Created by purblue on 6/7/16.
 */
/*
 * Print all the strings consisting of n X's and n Y's such that
 * no initial segment (prefix) of the string has more Y's than X's
 * Example n = 3 Total number of strings = 5. [[XXXYYY     XYXXYY     XYXYXY     XXYYXY     XXYXYY]]
 */
public class recursion {
    public static void run(int n){
        printPermutation("", n, n);
    }
    public static void printPermutation(String str, int numX, int numY){
        if(numX==0 && numY==0){
            System.out.println(str);
            return;
        }

        if(numX>0)
            printPermutation(str + "X", numX-1, numY);
        if(numY>0 && numX < numY)
            printPermutation(str + "Y", numX, numY-1);

    }

    public static void main(String[] args){
        run(3);
    }

}
