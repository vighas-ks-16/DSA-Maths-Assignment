import java.util.*;

public class LuckyNumbers
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int count = countLuckyNumbers(A);
        System.out.println(count);
    }

    public static int countLuckyNumbers(int A)
    {
        int count = 0;
        for (int i = 1; i <= A; i++)
        {
            int numDivisors = countDistinctPrimeDivisors(i);
            if (numDivisors == 2)
            {
                count++;
            }
        }
        return count;
    }

    public static int countDistinctPrimeDivisors(int n)
    {
        Set<Integer> primeDivisors = new HashSet<>();
        for (int i = 2; i <= n; i++)
        {
            if (n % i == 0)
            {
                while (n % i == 0)
                {
                    n /= i;
                }
                primeDivisors.add(i);
            }
        }
        return primeDivisors.size();
    }
}