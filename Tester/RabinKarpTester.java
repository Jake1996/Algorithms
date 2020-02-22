package Algorithms.Tester;

import Algorithms.String.RabinKarp;

public class RabinKarpTester {

	public static void main(String[] args) {
		String text = "ddjfjlkgdfgkjdfnglkjnhlkjcffh;lnfjg;xklf;glhdsjflksdjgfgfgf";
		String pattern = "fgkjdfnglkjnhlkjcffh;lnfjg;xklf;glhdsjflksdj";
		System.out
				.println(RabinKarp.findPatternInText(text.toCharArray(), pattern.toCharArray(), 0, text.length() - 1));
		// System.out.println(KMP.generatePrefixArray("abcabc".toCharArray())[4]);
	}

}
