import java.util.*;

public class PrimeSubsequences
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
        int count = countPrimeSubsequences(A);
        System.out.println(count);
    }

    public static int countPrimeSubsequences(int[] A)
    {
        int n = A.length;
        boolean[] isPrime = getPrimes(1000);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (isPrime[A[i] + A[j]])
                {
                    dp[i] += dp[j];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (isPrime[A[i]])
            {
                count += dp[i];
            }
        }
        return count;
    }

    public static boolean[] getPrimes(int n)
    {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++)
        {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}