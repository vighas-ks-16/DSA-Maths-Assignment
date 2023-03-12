import java.util.*;

public class SumOfPrimes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[] result = findPrimePair(A);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findPrimePair(int A)
    {
        int[] result = new int[2];
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);

        // Sieve of Eratosthenes algorithm to find all primes up to A
        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Find two prime numbers whose sum is equal to A
        for (int i = 2; i <= A/2; i++)
        {
            if (isPrime[i] && isPrime[A-i])
            {
                result[0] = i;
                result[1] = A - i;
                break;
            }
        }
        return result;
    }
}