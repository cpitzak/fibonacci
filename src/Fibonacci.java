
public class Fibonacci {

	// O(n)
	public long fibDP(int n) {
		Long m[] = new Long[n + 1];
		m[0] = (long) 1;
		m[1] = (long) 1;
		return fibDP(n, m);
	}

	private long fibDP(int n, Long m[]) {
		if (m[n] != null) {
			return m[n];
		}
		if (m[n - 1] == null) {
			m[n - 1] = fibDP(n - 1, m);
		}
		if (m[n - 2] == null) {
			m[n - 2] = fibDP(n - 2, m);
		}
		m[n] = m[n - 1] + m[n - 2];
		return m[n];
	}

	// O(1.6^n)
	public long fib(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String args[]) {
		Fibonacci a = new Fibonacci();
		/*
		 * note: the result uses long data type which goes up to 2^63 - 1, In
		 * Java SE 8 2^64 - 1. If you want to do large values use another data
		 * type however you'll see that it will be painful to wait for even
		 * fib(60) to be calculated.
		 */
		int number = 55;
		long startTime = System.currentTimeMillis();
		long fib = a.fibDP(number);
		long endTime = System.currentTimeMillis();
		System.out.println("Dynamic programming time taken to find fibonacci of " + number + ": "
				+ (endTime - startTime) + " miliseconds");
		System.out.println("The fibonacci number is: " + fib);

		System.out.println(
				"Now trying with plain recursive. Please be patient, this could be a while because worse case we are doing 1.6^n operations where n is "
						+ number);
		startTime = System.currentTimeMillis();
		fib = a.fib(number);
		endTime = System.currentTimeMillis();
		System.out.println("Plain recursive time taken to find fibonacci of " + number + ": " + (endTime - startTime)
				+ " miliseconds");
		System.out.println("The fibonacci number is: " + fib);

	}

}
