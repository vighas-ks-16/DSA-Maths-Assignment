import java.util.*;
public class nCr
{
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        Solution solution = new Solution();
        int result = solution.nCr(A, B, C);

        System.out.println(result);
    }
}

class Solution
{
    public int nCr(int A, int B, int C)
    {
        // Calculate factorials of A, B, and (A-B) modulo C
        int factA = factorial(A, C);
        int factB = factorial(B, C);
        int factAB = factorial(A - B, C);
        // Calculate modular inverse of factB * factAB modulo C
        int inv = modularInverse(factB * factAB % C, C);
        // Calculate nCr modulo C as factA * inv modulo C
        return factA * inv % C;
    }

    // Calculates x! modulo m
    private int factorial(int x, int m)
    {
        int fact = 1;
        for (int i = 2; i <= x; i++)
        {
            fact = fact * i % m;
        }
        return fact;
    }

    // Calculates the modular inverse of x modulo m
    private int modularInverse(int x, int m)
    {
        int a = x, b = m;
        int x0 = 1, x1 = 0;
        while (a > 1)
        {
            int q = a / b;
            int t = b; b = a % b; a = t;
            t = x0; x0 = x1 - q * x0; x1 = t;
        }
        if (x1 < 0) x1 += m;
        return x1;
    }
}
