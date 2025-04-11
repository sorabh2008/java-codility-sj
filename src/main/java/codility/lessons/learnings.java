import java.io.*;
import java.util.*;

class GFG {

	
	static void printPrimeFactors(int n)
	{
		if(n <= 1)
			return;

		while(n % 2 == 0)
		{
			System.out.print(2+" ");

			n = n / 2;
		}

		while(n % 3 == 0)
		{
			System.out.print(3+" ");

			n = n / 3;
		}

		for(int i=5; i*i<=n; i=i+6)
		{
			while(n % i == 0)
			{
				System.out.print(i+" ");

				n = n / i;
			}

			while(n % (i + 2) == 0)
			{
				System.out.print((i + 2)+" ");

				n = n / (i + 2);
			}
		}

		if(n > 3)
			System.out.print(n+" ");

		System.out.println();
	}

	public static void main (String[] args) {
		
		int n = 315;

		printPrimeFactors(n);

	}
}




class Test {
    // method to print the divisors
    static void printDivisors(int n)
    {
        // Vector to store half of the divisors
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
 
                // check if divisors are equal
                if (n / i == i)
                    System.out.printf("%d ", i);
                else {
                    System.out.printf("%d ", i);
 
                    // push the second divisor in the vector
                    v.add(n / i);
                }
            }
        }
 
        // The vector will be printed in reverse
        for (int i = v.size() - 1; i >= 0; i--)
            System.out.printf("%d ", v.get(i));
    }
 
    // Driver method
    public static void main(String args[])
    {
        System.out.println("The divisors of 100 are: ");
        printDivisors(100);
    }
}



/* Function to calculate x raised to the power y in
 * O(logn)*/
class GFG {
    /* Function to calculate x raised to the power y */
    static int power(int x, int y)
    {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }

    // Driver code
    public static void main(String[] args)
    {
        int x = 2;
        int y = 3;

        // Function call
        System.out.printf("%d", power(x, y));
    }
}



class GFG {
    //function that calculate modular exponentiation x^n mod m.
    public static int modpower(int x, int n, int m) {
        if (n == 0) //base case 
            return 1 % m; 
        long u = modpower(x, n / 2, m);  
        u = (u * u) % m;
        if (n % 2 == 1) // when 'n' is odd
            u = (u * x) % m;
        return (int)u;
    }

    //driver function
    public static void main(String[] args) {
        System.out.println(modpower(5, 2, 7));
    }
}




// Iterative Java program
// to implement pow(x, n)
import java.io.*;

class GFG
{
	
/* Iterative Function to
calculate (x^y) in O(logy) */
static int power(int x, int y)
{
	// Initialize result
	int res = 1;

	while (y > 0)
	{
		// If y is odd,
		// multiply
		// x with result
		if ((y & 1) == 1)
			res = res * x;

		// y must be even now
		y = y >> 1; // y = y/2
		x = x * x; // Change x to x^2
	}
	return res;
}

// Driver Code
public static void main (String[] args)
{
	int x = 3;
	int y = 5;

	System.out.println("Power is " +
						power(x, y));
}
}