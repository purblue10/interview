package data_structure;

/**
 * Created by purblue on 6/9/16.
 */
public class Greedy {
    public static void printMaxActivities(int s[], int f[], int n)
    {
        int i, j;
        // The first activity always gets selected
        i = 0;
        System.out.print(i+" ");

        // Consider rest of the activities
        for (j = 1; j < n; j++)
        {
            // If this activity has start time greater than or
            // equal to the finish time of previously selected
            // activity, then select it
            if (s[j] >= f[i])
            {
                System.out.print(j+" ");
                i = j;
            }
        }
    }

    // driver program to test above function
    public static void main(String[] args)
    {
        int s[] =  {0,3,8};
        int f[] =  {4,3,6};
        int n = s.length;

        printMaxActivities(s, f, n);
    }
}
