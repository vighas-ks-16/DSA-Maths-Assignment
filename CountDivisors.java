import java.util.*;

public class CountDivisors 
{
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < A.length; i++)
        {
            A[i] = sc.nextInt();
        }
        int[] result = countDivisors(A);
        System.out.println(Arrays.toString(result));
    }

    public static int[] countDivisors(int[] A)
    {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++)
        {
            int count = 0;
            for (int j = 1; j <= A[i]; j++)
            {
                if (A[i] % j == 0)
                {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}