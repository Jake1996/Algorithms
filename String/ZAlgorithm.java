package String;

import java.util.Arrays;

public class ZAlgorithm {
	public static int[] zfunction(char s[]) {
		int z[] = new int[s.length];
		int l=0,r=0;
		for(int i=1;i<s.length;i++) {
			if(i>r) {
				l=r=i;
				while(r<s.length&&s[r-l]==s[r]) {
					r++;
				}
				z[i] = r-l;
				r--;
			}
			else {
				int k = i-l;
				if(z[k] < r-i-+1) {
					z[i] = z[k];
				}
				else {
					l=i;
					while (r < s.length && s[r-l] == s[r]) 
		            {
		                r++;
		            }
		            z[i] = r-l; 
		            r--;
				}
			}
		}
		return z;
	}
	public static void patternMatch(String text,String pattern) {
		String s = pattern+"$"+text;
		int z[] = zfunction(s.toCharArray());
		for(int i=pattern.length()+1;i<s.length();i++) {
			if(z[i]==pattern.length()) {
				System.out.println("Pattern found at "+(i-pattern.length()-1));
			}
		}
	}
	public static void main(String args[]) {
		System.out.println(Arrays.toString(zfunction("aabbaabc".toCharArray())));
	}
}
