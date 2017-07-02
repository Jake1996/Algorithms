package NumberTheory;

public class exponentialmod {
	public static long apowbmodc(long a,long b,long c) {
		long ans = 1;
		a%=c;
		while(b!=0) {
			if( (b&1) == 1 ) {
				ans = ans*a;
				ans %= c;
			}
			a*=a;
			a%=c;
			b = b>>1;
		}
		return ans;
	}
}
