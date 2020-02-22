package Algorithms.NumberTheory;

import java.util.ArrayList;

public class NumberTheory {
	public static long gcd(long a, long b) {
		long temp;
		while (a != 0) {
			temp = a;
			a = b % a;
			b = temp;
		}
		return b;
	}

	public static long phiUsingGCD(long n) {
		long result = 1;
		for (int i = 2; i < n; i++) {
			if (gcd(i, n) == 1)
				result++;
		}
		return result;
	}

	public static long phi(long n) {
		long result = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				result -= result / i;
			}
		}
		if (n > 1)
			result -= result / n;
		return result;
	}

	public static int mobiusFunction(long n) {
		if (n == 1)
			return 1;
		int i = 2;
		int f = 0;
		int c = 0;
		while (n > 1) {
			c = 0;
			while (n % i == 0) {
				c++;
				f++;
				n /= i;
			}
			i++;
			if (c > 1)
				return 0;
		}
		return f % 2 == 0 ? 1 : -1;
	}

	/*
	 * false = prime
	 */
	public static boolean[] seive(int end) {
		boolean arr[] = new boolean[end + 1];
		for (int i = 2; i * i <= end; i++) {
			if (!arr[i])
				for (int j = i << 1; j <= end; j += i) {
					arr[j] = true;
				}
		}
		return arr;
	}

	public static ArrayList<Integer> generatePrime(int end) {
		boolean arr[] = new boolean[end + 1];
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 2; i <= end; i++) {
			if (!arr[i]) {
				primes.add(i);
				for (int j = i << 1; j <= end; j += i) {
					arr[j] = true;
				}
			}
		}
		return primes;
	}

	public static ArrayList<Long> generateFactors(int q) {
		ArrayList<Long> hm = new ArrayList<>();
		ArrayList<Integer> primes = generatePrime(q / 2 + 1);
		int i = 0;
		while (q > 1) {
			int cur = primes.get(i++);
			if (q % cur == 0)
				hm.add((long) cur);
			while (q % cur == 0) {
				q /= cur;
			}
		}
		return hm;
	}

	public static int numOfDivisors(int n) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i != i)
					count += 2;
				else
					count += 1;
			}
		}
		return count;
	}

	public static boolean isPowerOfTwo(long x) {
		if (x == 0)
			return false;
		if ((x & (x - 1)) != 0)
			return false;
		return true;
	}

	public static int coutNoOfOnes(long x) {
		int count = 0;
		while (x != 0) {
			x = x & (x - 1);
			count++;
		}
		return count;
	}

	public static long largestPower(long n) {
		n = n | (n >> 1);
		n = n | (n >> 2);
		n = n | (n >> 4);
		n = n | (n >> 8);
		return (n + 1) >> 1;
	}

}
