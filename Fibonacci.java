import java.util.Scanner;

public class Fibonacci {

	/* A recursive approach to finding the nth fibonacci, this approach has two
		main problems with it, First we are loading the call stack repeatedly with
		new recursiveFibonacci calls which can result in a StackOverflow error,
		Second we will be solving the same problem multiple times for example to
		find the 5th fibonacci number we have to solve the 3rd fibonacci number twice
		this doesnt seem that bad but imagine if we want the 100th fibonacci number */
	private int recursiveFibonacci(int n)
	{
		if(n < 2)
			return n;
		return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
	}

	/* A recursive apporach that utilizes the memoization technique, here we still
	make recursive calls but we store the values in an array so that if we later
	need to solve a fibonacci number that we already solved before we can just use
	the value we found before from our 'memo' array, this approach fixes the original
	approaches problem with solving the same fibonacci numbers mutliple times but
	is still susceptible to StackOverflow if the 'n' input is still high enough */
	private int memoizeFibonacci(int n, int[] memo)
	{
		if(n < 2)
			return n;
		if(memo[n] != 0)
			return memo[n];
		memo[n] = memoizeFibonacci(n-1, memo) + memoizeFibonacci(n-2, memo);
		return memo[n];
	}

	/* An iterative approach that solves the problems with the two previous approaches,
	it cannot cause a StackOverflow error and will not solve the same fibonacci numbers
	more than once, what we do is find every fiboncacci number up until n, these are stored
	in the 'memoizeArr' array so when we finish we return memoizeArr[n] */
	private int bottomUpFibonacci(int n)
	{
		int[] memoizeArr = new int[n+1];
		for(int i = 1; i <= 2; i++)
			memoizeArr[i] = 1;
		for(int i = 3; i <= n; i++)
			memoizeArr[i] = memoizeArr[i-1] + memoizeArr[i-2];
		return memoizeArr[n];
	}

	/* A basic function used to ask the user for an integer with the provided message */
	private static int ScannerResult(String message)
	{
		int result = 0;
		Scanner scanner = new Scanner(System.in);
		try
		{
			System.out.println(message);
			result = scanner.nextInt();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/* This function starts the program */
	public static void Start()
	{
		int fibOf = 0;
		int usersChoice = 0;
		long startTime = 0;
		long endTime = 0;
		long duration = 0;
		Fibonacci fib = new Fibonacci();

		while(usersChoice != 4)
		{
			usersChoice = ScannerResult("\nPlease choose an option\n1 - Recursive Fibonacci\n2 - Memoize Fibonacci\n3 - Bottom Up Fibonacci\n4- Exit\n");
			switch(usersChoice)
			{
				case 1:
					fibOf = ScannerResult("\nPlease enter a number to find the fibonacci of");
					startTime = System.nanoTime();
					fib.recursiveFibonacci(fibOf);
					endTime = System.nanoTime();
					duration = (endTime - startTime);
					System.out.printf("\nThat took %d nanoSeconds\n", duration);
					break;
				case 2:
					fibOf = ScannerResult("\nPlease enter a number to find the fibonacci of");
					startTime = System.nanoTime();
					int[] memoizeArr = new int[fibOf + 1];
					fib.memoizeFibonacci(fibOf, memoizeArr);
					endTime = System.nanoTime();
					duration = (endTime - startTime);
					System.out.printf("\nThat took %d nanoSeconds\n", duration);
					break;
				case 3:
					fibOf = ScannerResult("\nPlease enter a number to find the fibonacci of");
					startTime = System.nanoTime();
					fib.bottomUpFibonacci(fibOf);
					endTime = System.nanoTime();
					duration = (endTime - startTime);
					System.out.printf("\nThat took %d nanoSeconds\n", duration);
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Please give a valid input");
					break;
			}
		}
	}

	public static void main(String[]args)
	{
		Start();
	}
}
