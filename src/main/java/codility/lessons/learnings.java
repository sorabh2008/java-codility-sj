import java.io.*;
import java.util.*;





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