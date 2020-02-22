package Algorithms.Tester;

import Algorithms.NumberTheory.NumberTheory;

public class NumberTheoryTester {

	public static void main(String[] args) {
		// System.out.println(NumberTheory.gcd(6, 0));
		// for(int i=0;i<10;i++) {
		// System.out.println(NumberTheory.phi(i));
		// }
		for (int i = 0; i < 10; i++)
			System.out.println(NumberTheory.mobiusFunction(i));
		System.out.println(NumberTheory.mobiusFunction(78));
		System.out.println(NumberTheory.mobiusFunction(12));
		System.out.println(NumberTheory.mobiusFunction(34));
		System.out.println(NumberTheory.mobiusFunction(17));

	}
}
