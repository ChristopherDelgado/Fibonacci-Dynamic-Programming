import java.util.Scanner;

public class Fibonacci {

	private int recursiveFibonacci(int n)
	{
		if(n < 2)
			return n;
		return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
	}

	private int memoizeFibonacci(int n, int[] memo)
	{
		if(n < 2)
			return n;
		if(memo[n] != 0)
			return memo[n];
		memo[n] = memoizeFibonacci(n-1, memo) + memoizeFibonacci(n-2, memo);
		return memo[n];
	}

	private int bottomUpFibonacci(int n)
	{
		int[] memoizeArr = new int[n+1];
		for(int i = 1; i <= 2; i++)
			memoizeArr[i] = 1;
		for(int i = 3; i <= n; i++)
			memoizeArr[i] = memoizeArr[i-1] + memoizeArr[i-2];
		return memoizeArr[n];
	}

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
