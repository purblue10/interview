package data_structure.etc;

import java.util.*;

/**
 * Created by purblue on 6/1/16.
 */
public class Misc {
    int num_rec = 0;
    public int multiplyWithoutStar(int a, int b){
        num_rec++;
        if(a==0 || b==0)
            return 0;

        if(b==1)
            return a;
        else if(b>1)
            return a+a+multiplyWithoutStar(a, b-2);
        else
            return -multiplyWithoutStar(a, -b);
    }

//    abcd 3.0 xyx 4.0 foobar 5.0
    public String getRandomString(String str){
        String[] arr = str.split(" ");
        int sum = 0;
        for(int i = 1; i<arr.length; i+=2){
            sum+= (int) Double.parseDouble(arr[i]);
        }
        Random rand = new Random();
        int num = rand.nextInt(sum) + 1;
        int i=1;
        while(num>0){
            num -= (int) Double.parseDouble(arr[i]);
            if(num>0)
                i+=2;
        }
        return arr[i-1];
    }

    public static void main(String[] args){
        Misc misc = new Misc();
        for(int i=0; i<100; i++)
            System.out.println(misc.getRandomString("abcd 3.0 xyx 4.0 foobar 5.0"));
    }


}
